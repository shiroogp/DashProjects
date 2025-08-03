const resetData = {
  canData: {
    rpm: 0,
    vss: 0,
    tps: 0,
    map: 0,
    clt: 0,
    mat: 0,
    oilPress: 0,
    oilTemp: 0,
    fuelPress: 0,
    gear: "N",
    lambda: 0,
    afr: 0,
    batt: 0,
    boost: 0,
    odoNow: 0,
    mapbar: 0,
  },
  basicData: {
    rpm: 0,
    kmh: 0,
    kmhF: 0,
    clt: 0,
    lvlFuel: 0,
    lvlFuelF: 0,
    turnLeft: 1,
    turnRight: 1,
    parkLights: 1,
    fogLights: 1,
    auxLights: 1,
    highBeam: 1,
    eBrake: 1,
    battAlt: 1,
    ECUErr: 1,
    oilSwitch: 1,
    rearDefrost: 1,
    fan: 1,
    openDoor: 1,
    airbag: 1,
    odoNow: 0,
  },
};
let canData = resetData.canData,
  basicData = resetData.basicData,
  isECUOnline = !1,
  isBasicOnline = !1,
  odoDebounce = !1,
  DASH_OPTIONS = {
    ...defaultOptions,
    ...(JSON.parse(localStorage.getItem(CONFIG.CONFIG_STORAGE_KEY)) || {}),
  },
  lastTime = 0,
  tick = 0,
  enableSimulator = !1;
  enableWS = !1;
// // const dgram = require('dgram');
var ws;
var ecuDataSplit;
var ecuDataSplittest= [];

function initws() {
  // Connect to Web Socket
  ws = new WebSocket("ws://192.168.1.74:8738/ws");

  // Set event handlers.
  ws.onopen = function () {
    output("onopen");
  };

  ws.onmessage = function (e) {
    // e.data contains received string.
    // output("onmessage: " + e.data);
    ecuDataSplittest = e.data.split(" ");
    if (ecuDataSplittest.length > 150) {
      ecuDataSplit = e.data.split(" ");      
    }
    // output("ecudata: " + ecuDataSplit);
  };

  ws.onclose = function () {
    output("onclose");
  };

  ws.onerror = function (e) {
    output("onerror");
    console.log(e);
  };
}

function onSubmit() {
  var input = document.getElementById("input");
  // You can send message to the Web Socket using ws.send.
  ws.send(input.value);
  output("send: " + input.value);
  input.value = "";
  input.focus();
}

function onCloseClick() {
  ws.close();
}

function output(str) {
  console.log(str);
  // var log = document.getElementById("log");
  // var escaped = str.replace(/&/, "&amp;").replace(/</, "&lt;").
  //   replace(/>/, "&gt;").replace(/"/, "&quot;"); // "
  // log.innerHTML = escaped + "<br>" + log.innerHTML;
}

// init();



const COLORS = DASH_OPTIONS.theme.colors,
  elemCache = {},
  root = document.documentElement,
  mainContainer = document.getElementById("container"),
  saveSettings = (a) => {
    (DASH_OPTIONS =
      JSON.parse(localStorage.getItem(CONFIG.CONFIG_STORAGE_KEY)) || {}),
      (DASH_OPTIONS = { ...defaultOptions, ...DASH_OPTIONS, ...a }),
      localStorage.setItem(
        CONFIG.CONFIG_STORAGE_KEY,
        JSON.stringify(DASH_OPTIONS)
      );
  },
  disconnect = () => {
    (enableSimulator = !1),
      setTimeout(() => {
        (isECUOnline = !1), (isBasicOnline = !1);
      }, 100),
      mainContainer.classList.remove("connected");
  },
  openConnection = (a) => {
    (enableSimulator = !0),
      (isECUOnline = !0),
      (isBasicOnline = !0),
      mainContainer.classList.add("connected"),
      requestAnimationFrame(a);
  },
  checkCache = (a, t) => {
    const e = "string" == typeof a ? a : a.getAttribute("id");
    return elemCache[e] === t || ((elemCache[e] = t), !1);
  },
  etoggle = (a, t) => {
    a && !checkCache(a, t) && a.setAttribute("data-etoggle", 1 - t);
  },
  setText = (a, t) => {
    a && !checkCache(a, t) && (a.textContent = t);
  },
  setRootCSS = (a, t) => {
    a && !checkCache(a, t) && root.style.setProperty(a, t);
  },
  setGaugeValue = (a, t, e = null) => {
    a &&
      a.value &&
      !checkCache(`${a.id}-now`, t) &&
      (e && root.style.setProperty(`--${a.id}-bar`, e),
        (a.value.textContent = t));
  },
  setIconOpacity = (a, t) => setRootCSS(`--${a}-icon`, 1 - t),
  zeroFixed = (a) => Math.round(a || 0),
  oneFixed = (a) => Math.round(10 * (a || 0)) / 10,
  twoFixed = (a) => Math.round(100 * (a || 0)) / 100,
  mapFormat = (a) =>
    +a < 1 ? `-${("" + a).substring(1, 4)}` : (+a - 1).toFixed(2),
  boostFormat = (a) => (+a < 1 ? 0 : twoFixed(+a - 1)),
  safeReturn = (a, t, e = 0) => a[t] || e,
  mapBarFormat = (a) => (a < 0 ? a / 2 : a / (2 * DASH_OPTIONS.pBoost)),
  setGaugeBar = (a, t, e = !1, o) => {
    a &&
      !checkCache(`${a}-gauge-bar`, t) &&
      root.style.setProperty(
        `--${a}-gauge-bar`,
        e
          ? (+t / (o || DASH_OPTIONS[a])) * 100 + "%"
          : +t / (o || DASH_OPTIONS[a])
      );
  },
  setCLTBar = (a, t) => setGaugeBar("clt", a, t),
  setMATBar = (a, t) => setGaugeBar("mat", a, t),
  setOilPressBar = (a, t) => setGaugeBar("pOil", a, t),
  setFuelPressBar = (a, t) => setGaugeBar("pFuel", a, t),
  setBoostBar = (a, t) => setGaugeBar("pBoost", a, t),
  setOilTempBar = (a, t) => setGaugeBar("tOil", a, t),
  setFuelLevelBar = (a, t) => setGaugeBar("lFuel", a, t, 100),
  setBatteryBar = (a, t) => setGaugeBar("batt", a, t),
  setSpeedBar = (a, t) => setGaugeBar("spdM", a, t),
  setRPMBar = (a, t) => setGaugeBar("rpmM", a, t, 1e3 * DASH_OPTIONS.rpmM),
  setTPSBar = (a, t) => setGaugeBar("tps", a, t, 100),
  setAFRBar = (a, t) => setGaugeBar("afr", a, t, 20),
  setLambdaBar = (a, t) => setGaugeBar("lambda", a, t, 2),
  fuelLevelFormat = (a, t) => {
    const e = safeReturn(a, t);
    return zeroFixed(e > 100 ? 100 : e < 0 ? 0 : e);
  },
  loadOdo = (a, t, e, o = !1) => {
    const s = DASH_OPTIONS.kmTrip + e,
      r = DASH_OPTIONS.kmTotal + e;
    setText(t, zeroFixed(s)),
      setText(a, zeroFixed(+DASH_OPTIONS.tKm + r)),
      o && saveSettings({ kmTrip: s, kmTotal: r });
  },
  updateOdo = (a, t, e) => {
    0 === DASH_OPTIONS.kmTrip && setText(t, 0),
      0 === e ||
      odoDebounce ||
      isNaN(e) ||
      ((odoDebounce = !0),
        loadOdo(a, t, e, !0),
        setTimeout(() => {
          odoDebounce = !1;
        }, 1e3));
  },
  resetOdo = () => saveSettings({ kmTrip: 0 }),
  useCanChannel = (a = null) =>
    isECUOnline && DASH_OPTIONS.sCan < 2 && (!a || DASH_OPTIONS[a] > 1),
  randomStatus = (a) => (Math.floor(20 * Math.random()) > 18 ? !a : a),
  simulateGear = (a) => (a > 2 ? a - 2 : ["P", "N", "R"][a]),
  simulator = (a) => {
    if (a - lastTime > 33 && !enableSimulator) {
      tick = tick > 999 ? 0 : tick + 1;
      const e = tick > 499 ? (1e3 - tick) / 500 : tick / 500;
      (canData = {
        rpm: e * +DASH_OPTIONS.rpmM * 1e3,
        vss: e * +DASH_OPTIONS.spdM,
        tps: (100 * e).toFixed(1),
        map: (e * (+DASH_OPTIONS.pBoost + 1)).toFixed(2),
        clt: (e * +DASH_OPTIONS.clt).toFixed(0),
        mat: (e * +DASH_OPTIONS.mat).toFixed(0),
        oilPress: (e * +DASH_OPTIONS.pOil).toFixed(1),
        oilTemp: (e * +DASH_OPTIONS.tOil).toFixed(0),
        fuelPress: (e * +DASH_OPTIONS.pFuel).toFixed(1),
        gear: ((t = zeroFixed(10 * e)), t > 2 ? t - 2 : ["P", "N", "R"][t]),
        boost: e * +DASH_OPTIONS.pBoost,
        batt: (e * +DASH_OPTIONS.batt).toFixed(1),
        lambda: (2 * e).toFixed(2),
        afr: (8 + 12 * e).toFixed(2),
        odoNow: tick % 250 == 0 ? 1 : 0,
      }),
        (basicData = {
          rpm: canData.rpm,
          kmh: canData.vss,
          kmhF: canData.vss,
          clt: canData.clt,
          lvlFuel: 100 * e,
          lvlFuelF: 100 * e,
          odoNow: canData.odoNow,
          turnLeft: randomStatus(basicData.turnLeft),
          turnRight: randomStatus(basicData.turnRight),
          parkLights: randomStatus(basicData.parkLights),
          fogLights: randomStatus(basicData.fogLights),
          auxLights: randomStatus(basicData.auxLights),
          highBeam: randomStatus(basicData.highBeam),
          eBrake: randomStatus(basicData.eBrake),
          battAlt: randomStatus(basicData.battAlt),
          ECUErr: randomStatus(basicData.ECUErr),
          oilSwitch: randomStatus(basicData.oilSwitch),
          rearDefrost: randomStatus(basicData.rearDefrost),
          fan: randomStatus(basicData.fan),
          openDoor: randomStatus(basicData.openDoor),
          airbag: randomStatus(basicData.airbag),
        }),
        (lastTime = a);
    }
    if (a - lastTime > 33) {
      tick = tick > 999 ? 0 : tick + 1;
      const e = tick > 499 ? (1e3 - tick) / 500 : tick / 500;
      //CORE
      try {
        var list = ecuDataSplit;
        var map = parseFloat(list[4]);
        var baro = parseFloat(list[40]);

        var map_bar = (map - baro) / 101.33;
        var map_psi = (map - baro) * 0.145038;
        var map_inhg = (baro - map) * 0.2953007;
        var map_vacboost = map < baro ? -map_inhg : map_psi;

        var coolantRaw = parseFloat(list[7]);
        var coolant = coolantRaw - 40;
        var iatRaw = parseFloat(list[6]);
        var iat = iatRaw - 40;
        var fueltempRaw = parseFloat(list[114]);
        var fueltemp = fueltempRaw - 40;
        var afr = parseFloat(list[10]);
        var stoich = 14.7;
        var afrTarget = parseFloat(list[21]);
        var lambda = afr / stoich;
        var lambdaTarget = afrTarget / stoich;
        var fuelpressureRaw = parseFloat(list[105]);
        var fuelpressure = fuelpressureRaw * 0.06894;
        var oilpressureRaw = parseFloat(list[105]);
        var oilpressure = oilpressureRaw * 0.06894;
        // setText(mapBoost, mapFormat(map_psi));
        // setText(fuelPressure, fuelpressure);
        // setText(battLevel, parseFloat(list[9]));
        // setText(lambda, afr);
        // setText(oilPressure, oilpressure);
        // updateRPM(parseFloat(list[14]))
        // setKmhDeg([parseFloat(list[14]) / 10, basicData.kmhF])

          (canData = {
            rpm: parseFloat(list[14]),
            vss: parseFloat(list[14])/10,
            tps: parseFloat(list[24]),
            map: map_bar.toFixed(2),
            clt: coolant.toFixed(0),
            mat: iat.toFixed(0),
            oilPress: oilpressure.toFixed(1),
            oilTemp: fueltemp.toFixed(0),
            fuelPress: fuelpressure.toFixed(1),
            gear: ((t = zeroFixed(10 * e)), t > 2 ? t - 2 : ["P", "N", "R"][t]),
            boost: map_psi,
            batt: parseFloat(list[9]).toFixed(1),
            lambda: (afr / stoich).toFixed(2),
            afr: afr.toFixed(2),
            odoNow: tick % 250 == 0 ? 1 : 0,
          }),
          (basicData = {
            rpm: canData.rpm,
            kmh: canData.vss,
            kmhF: canData.vss,
            clt: canData.clt,
            lvlFuel: 100 * e,
            lvlFuelF: 100 * e,
            odoNow: canData.odoNow,
            turnLeft: randomStatus(basicData.turnLeft),
            turnRight: randomStatus(basicData.turnRight),
            parkLights: randomStatus(basicData.parkLights),
            fogLights: randomStatus(basicData.fogLights),
            auxLights: randomStatus(basicData.auxLights),
            highBeam: randomStatus(basicData.highBeam),
            eBrake: randomStatus(basicData.eBrake),
            battAlt: randomStatus(basicData.battAlt),
            ECUErr: randomStatus(basicData.ECUErr),
            oilSwitch: randomStatus(basicData.oilSwitch),
            rearDefrost: randomStatus(basicData.rearDefrost),
            fan: randomStatus(basicData.fan),
            openDoor: randomStatus(basicData.openDoor),
            airbag: randomStatus(basicData.airbag),
          }),
          (lastTime = a);
          console.log(canData);
          console.log(basicData);
      } catch (error) {
        console.log(error);
      }
      //END Core      

    }
    enableSimulator ||
      ((canData = resetData.canData),
        (basicData = resetData.basicData),
        (tick = 0)),
      requestAnimationFrame(simulator);
  };
requestAnimationFrame(simulator);
const toggleSimulator = () => {
  if (enableSimulator) return (enableSimulator = !1), void disconnect();
  (enableSimulator = !0), openConnection(() => null);
};
const connecttows = () => {
  if (enableWS) return (enableWS = !1);
  (enableWS = !0), initws();
};
window.addEventListener("load", () => {
  window.addEventListener(
    "message",
    (a) => {
      switch (a.data.action) {
        case "odoreset":
          saveSettings({ kmTrip: 0 });
          break;
        case "toggleSimulator":
          toggleSimulator();
          break;
        case "connecttows":
          connecttows();
          break;
        case "animIn":
          setTimeout(() => openConnection(() => null), 6500),
            mainContainer.classList.replace("anim-out", "anim-in");
          break;
        case "animOut":
          disconnect(), mainContainer.classList.replace("anim-in", "anim-out");
          break;
        default:
          break;
      }
    },
    !1
  );
});
