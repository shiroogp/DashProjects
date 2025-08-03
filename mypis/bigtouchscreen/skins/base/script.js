// var ws;
// var ecuDataSplit;
// function init() {
//   // Connect to Web Socket
//   ws = new WebSocket("ws://pidash:8080/ws");

//   // Set event handlers.
//   ws.onopen = function () {
//     output("onopen");
//   };

//   ws.onmessage = function (e) {
//     // e.data contains received string.
//     output("onmessage: " + e.data);
//     ecuDataSplit = e.data.split(" ");
//     output("ecudata: " + ecuDataSplit);
//   };

//   ws.onclose = function () {
//     output("onclose");
//   };

//   ws.onerror = function (e) {
//     output("onerror");
//     console.log(e);
//   };
// }

// function onSubmit() {
//   var input = document.getElementById("input");
//   // You can send message to the Web Socket using ws.send.
//   ws.send(input.value);
//   output("send: " + input.value);
//   input.value = "";
//   input.focus();
// }

// function onCloseClick() {
//   ws.close();
// }

// function output(str) {
//   console.log(str);
//   // var log = document.getElementById("log");
//   // var escaped = str.replace(/&/, "&amp;").replace(/</, "&lt;").
//   //   replace(/>/, "&gt;").replace(/"/, "&quot;"); // "
//   // log.innerHTML = escaped + "<br>" + log.innerHTML;
// }

// init();

const callback = () => {
  // Variables, constants and DOM elements
  const signals = [
    'turnLeft', 'turnRight', 'battAlt', 'eBrake', 'highBeam', 'parkLights',
    'fogLights', 'auxLights', 'openDoor', 'fan', 'oilSwitch', 'ECUErr'
  ];
  const elems = [
    ...signals, 'container', 'speedo', 'rpm', 'kmTrip', 'kmTotal', 'fuelLevel',
    'battLevel', 'fuelPressure', 'lambda', 'oilPressure', 'mapBoost', 'cltNow'
  ].reduce((acc, id) => ({ ...acc, [id]: document.getElementById(id) }), {});
  const {
    container, speedo, rpm, kmTrip, kmTotal, battLevel,
    fuelPressure, lambda, oilPressure, mapBoost, fuelLevel, cltNow
  } = elems;
  const { cMain, cSec, cRed } = COLORS
  const { aSpd, redline, icon } = DASH_OPTIONS
  const maxRPM = 8000;
  let [useCAN, useCANForRPM, useCANForVSS, useCANForCLT] = [false, false, false, false]

  // Set static parameters
  setRootCSS('--background-color', cMain);
  setRootCSS('--mini-bar', `90deg, ${cMain}33, ${cMain}FF`);
  setRootCSS('--mini-bar-red', `90deg, ${cSec}33, ${cSec}FF`);

  // Load odometer
  loadOdo(kmTotal, kmTrip, 0)

  // Wrapper method to update the RPM
  const updateRPM = (value) => {
    setText(rpm, zeroFixed(value))
    if (+value > maxRPM) return
    setRootCSS('--rpm-deg', `${-(155 + ((+value / maxRPM) * 230))}deg`)
    setRootCSS('--background-color', (+value < redline ? cMain : cRed));
  }

  // Wrapper method to update the speedometer
  const setKmhDeg = ([val, valf]) => {
    setText(speedo, zeroFixed(aSpd < 2 ? (valf || val) : val))
    if (checkCache('kmh-deg', val) || val > 160) return
    setRootCSS('--kmh-deg', `${(155 + ((val / 160) * 230))}deg`)
  }

  // Cache the settings for channel sources locally
  const checkSource = () => [useCAN, useCANForRPM, useCANForVSS, useCANForCLT] = [
    useCanChannel(),
    useCanChannel('sRpm'),
    useCanChannel('sVss'),
    useCanChannel('sClt'),
  ]

  // Bind the realtime data to the DOM
  const bindRealtimeData = () => {
    // Check if the source has changed and update the cache
    if (!checkCache('useCAN', useCanChannel())) checkSource();

    // Update the data for CAN-only channels - batching methods for performance
    if (useCAN) {
      setText(mapBoost, mapFormat(canData.map))
      setText(fuelPressure, canData.fuelPress)
      setText(battLevel, canData.batt)
      setText(lambda, canData.lambda)
      setText(oilPressure, canData.oilPress)
    }

    // Update the data for Basic-only channels
    if (isBasicOnline) {
      setText(fuelLevel, fuelLevelFormat(basicData, 'lvlFuel'))
      setFuelLevelBar(safeReturn(basicData, 'lvlFuel'))

      // Toggle signals
      for (let i = 0; i < signals.length; i++) {
        etoggle(elems[signals[i]], basicData[signals[i]])
      }
    }

    // Update the data for channels that can be sourced from CAN or Basic servers
    updateRPM(useCANForRPM ? canData.rpm : safeReturn(basicData, 'rpm'))
    setKmhDeg(useCANForVSS ? [canData.vss] : [basicData.kmh, basicData.kmhF])
    setCLTBar(useCANForCLT ? canData.clt : safeReturn(basicData, 'clt'))
    setText(cltNow, useCANForCLT ? canData.clt : zeroFixed(safeReturn(basicData, 'clt')))
    updateOdo(kmTotal, kmTrip, useCANForVSS ? canData.odoNow : basicData.odoNow)


    // //CORE
    // try {
    //   var list = ecuDataSplit;
    //   var map = parseFloat(list[4]);
    //   var baro = parseFloat(list[40]);
  
    //   var map_bar = (map - baro) / 101.33;
    //   var map_psi = (map - baro) * 0.145038;
    //   var map_inhg = (baro - map) * 0.2953007;
    //   var map_vacboost = map < baro ? -map_inhg : map_psi;
  
    //   var coolantRaw = parseFloat(list[7]);
    //   var coolant = coolantRaw - 40;
    //   var iatRaw = parseFloat(list[6]);
    //   var iat = iatRaw - 40;
    //   var fueltempRaw = parseFloat(list[114]);
    //   var fueltemp = fueltempRaw - 40;
    //   var afr = parseFloat(list[10]);
    //   var stoich = 14.7;
    //   var afrTarget = parseFloat(list[21]);
    //   var lambda = afr / stoich;
    //   var lambdaTarget = afrTarget / stoich;
    //   var fuelpressureRaw = parseFloat(list[105]);
    //   var fuelpressure = fuelpressureRaw * 0.06894;
    //   var oilpressureRaw = parseFloat(list[105]);
    //   var oilpressure = oilpressureRaw * 0.06894;
    //   setText(mapBoost, mapFormat(map_psi))
    //   setText(fuelPressure, fuelpressure)
    //   setText(battLevel, parseFloat(list[9]))
    //   setText(lambda, afr)
    //   setText(oilPressure, oilpressure)
    //   updateRPM(parseFloat(list[14]))
    //   setKmhDeg([parseFloat(list[14]) / 10, basicData.kmhF])
  
    //   // m_dashboard->setAFR(list[10]));
    //   // m_dashboard->setBoostDuty(list[30]));
    //   // m_dashboard->setBoostPres(map_bar);
    //   // m_dashboard->setDwell(list[89]));
    //   // m_dashboard->setexcamangle1(list[93]));
    //   // m_dashboard->setexcamangle2(list[109]));
  
    //   // m_dashboard->setFuelPress(fuelpressure);
    //   // m_dashboard->setFueltemp(fueltemp);
    //   // m_dashboard->setIntaketemp(iat);
    //   // m_dashboard->setLAMBDA(lambda);
    //   // m_dashboard->setLAMBDATarget(lambdaTarget);
    //   // m_dashboard->setMAP(list[4]));
    //   // m_dashboard->setoilpres(oilpressure);
    //   // m_dashboard->setrpm(list[14]));
    //   // m_dashboard->setSpeed(list[14])/10);
    //   // m_dashboard->setTPS(list[24]));
    //   // m_dashboard->setWatertemp(coolant);
    //   // m_dashboard->setBatteryV(list[9]));
    //   // m_dashboard->setIntakepress(map_bar);
    // } catch (error) {
    //   console.log(error);
    // }
    // //END Core


    // Repeat bindRealtimeData as fast as possible
    requestAnimationFrame(bindRealtimeData);
  }

  // Replace the icons with the colored ones
  (() => {
    if (icon === 1) return
    const icons = document.querySelectorAll('#top-info img')
    for (let i = 0; i < icons.length; i++) {
      icons[i].src = icons[i].src.replace('icons', 'icons_color')
    }
  })()

  // Wait animations to finish and then open websocket connection
  setTimeout(() => openConnection(bindRealtimeData), 6500)
  connecttows()
  // Trigger animation when DOM is ready
  container.classList.add('anim-in')
};

// Start the script when DOM is ready
window.onload = () => callback()
