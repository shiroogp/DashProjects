import os
import pygame
import time
import struct
from websocket import create_connection
# import shift_light_v2
ws = create_connection("ws://192.168.1.74:8738/ws")
# os.environ['SDL_VIDEODRIVER'] = 'fbcon'   #set up os environment to display to TFT
os.environ['SDL_FBDEV'] = '/dev/fb1'
os.putenv('SDL_FBDEV','/dev/fb1')
os.putenv('SDL_MOUSEDEV', '/dev/input/event0')
os.environ['SDL_MOUSEDEV'] = '/dev/input/event0'

# PC test mode
TEST_MODE = True

# Screen size
# screen = pygame.display.set_mode((0,0), pygame.FULLSCREEN)
# width, height = screen.get_size()
size = width, height = (480, 320)
screen = pygame.display.set_mode(size)
pygame.display.init()
pygame.font.init()
scalex = width/800
scaley = height/480
led_br = 80

if TEST_MODE is False:
    import os
    import can
    import mcp3002
    from rpi_hardware_pwm import HardwarePWM
    pygame.mouse.set_visible(False)
    PATH = "/home/your_user_name/Dash/"
    # Can bus
    os.system('ip link set can0 type can bitrate 500000')
    os.system('ifconfig can0 up')
    can_bus_filter = [{"can_id": 0x607, "can_mask": 0x5F8 , "extended": False}]
    can_bus = can.Bus(channel="can0", interface="socketcan", can_filters=can_bus_filter)
    # Pwm
    backlight = HardwarePWM(pwm_channel=0, hz=500, chip=0)
    backlight.start(70)
else:
    PATH = ""

# Read needed files
units_memory = open(PATH + "units_memory.txt", "r")
units = units_memory.read().splitlines()
units_memory.close()
odometer_memory = open(PATH + "odometer_memory.txt", "r")
odometer = float(odometer_memory.readline())
odometer_memory.close()

# Variables
start_up = True
timeout_counter = 0
rpm = 0
speed = 0
gear = 0
out_temp = 0
fuel_level = None
fuel_used = 0
raw_fuel_level = 0
refuel = False
batt_v = 0
left_blinker = False
right_blinker = False
high_beam = False
errors = 0
speed_sum = 0
speed_sum_counter = 0
old_rpm = None
old_gear = None
old_speed = None
old_out_temp = None
old_odometer = odometer
old_clock = None
old_error_list = None
old_refuel = None
old_right_blinker = None
old_left_blinker = None
old_high_beam = None
values = {x : 0 for x in units}
old_values = {x : None for x in units}
odometer_start = odometer
clear = True
loop = True
touch = False
start = True
filter_counter = 0
filter_sum = 0
countdown = 10
unit_change = None
units_ok = True
draw_menu = False
old_cpu_temp = None
shift_changed = 10
shift_light_off = False
power_off = False
cpu_timer = time.monotonic()
blink_timer = time.monotonic()
dimmer_timer_1 = time.monotonic()
dimmer_timer_4 = time.monotonic()
distance_timer = time.monotonic()

# CONSTANTS
ECU_CAN_ID = 0x600
FUEL_MAX = 197
FUEL_MIN = 36
FUEL_DIVIDER = (FUEL_MAX - FUEL_MIN) / 100
CENTER_X, CENTER_Y = (width / 2, height / 2)
RIGHT_SIDE = width - (180*scalex)
RED = (255, 0, 0)
ORANGE = (255, 165, 0)
YELLOW = (255,255,0)
WHITE = (255, 255, 255)
DARK_BLUE = (0, 64, 128)
LIGHT_BLUE = (0, 128, 255)
GREEN = (0, 255, 0)
BLACK = (0, 0, 0)
# Shift light
END = 8600
STEP = 300
SHIFTONE = 7500
SHIFTTWO = 8500
SHIFTTHREE = 9500
MAX = 10000
# Close io devices
def close_io():
    mcp3002.close()
    can_bus.shutdown()
    os.system('ifconfig can0 down')
    backlight.stop()

# Touchscreen coordinate return
def touch_xy(x, y):
    return (int(x * width), int(y * height))

# Odometer calculations and file save
def odometer_save(speed_sum, speed_sum_counter, distance_timer, odometer, PATH):
    if speed_sum == 0:
        return odometer
    average_speed = (speed_sum / speed_sum_counter) * 0.27777778
    timer = time.monotonic() - distance_timer
    distance = (average_speed * timer) / 1000
    odometer = odometer + distance
    # Saving to memory
    odometer_memory = open(PATH + "odometer_memory.txt", "w")
    odometer_memory.write(str(odometer))
    odometer_memory.close()
    return odometer

def menu(pos):
    if pygame.Rect.collidepoint(rpm_button, pos):
        return "rpm"
    elif pygame.Rect.collidepoint(tps_button, pos):
        return "tps"
    elif pygame.Rect.collidepoint(iat_button, pos):
        return "iat"
    elif pygame.Rect.collidepoint(map_button, pos):
        return "map"
    elif pygame.Rect.collidepoint(inj_pw_button, pos):
        return "inj_pw"
    elif pygame.Rect.collidepoint(oil_t_button, pos):
        return "oil_t"
    elif pygame.Rect.collidepoint(oil_p_button, pos):
        return "oil_p"
    elif pygame.Rect.collidepoint(fuel_p_button, pos):
        return "fuel_p"
    elif pygame.Rect.collidepoint(clt_t_button, pos):
        return "clt_t"
    elif pygame.Rect.collidepoint(ign_ang_button, pos):
        return "ign_ang"
    elif pygame.Rect.collidepoint(dwell_button, pos):
        return "dwell"
    elif pygame.Rect.collidepoint(lambda_button, pos):
        return "lambda"
    elif pygame.Rect.collidepoint(lambda_corr_button, pos):
        return "lambda_corr"
    elif pygame.Rect.collidepoint(egt_1_button, pos):
        return "egt_1"
    elif pygame.Rect.collidepoint(egt_2_button, pos):
        return "egt_2"
    elif pygame.Rect.collidepoint(ethanol_cont_button, pos):
        return "ethanol_cont"
    elif pygame.Rect.collidepoint(batt_v_button, pos):
        return "batt_v"
    elif pygame.Rect.collidepoint(dbw_pos_button, pos):
        return "dbw_pos"
    elif pygame.Rect.collidepoint(boost_t_button, pos):
        return "boost_t"
    elif pygame.Rect.collidepoint(dsg_mode_button, pos):
        return "dsg_mode"
    elif pygame.Rect.collidepoint(lambda_t_button, pos):
        return "lambda_t"
    elif pygame.Rect.collidepoint(fuel_used_button, pos):
        return "fuel_used"
    elif pygame.Rect.collidepoint(fuel_level_button, pos):
        return "fuel_level"
    elif pygame.Rect.collidepoint(fuel_consumption_button, pos):
        return "fuel_consum"

# Read light sensor value
def is_dark(old_value):
    a_val = mcp3002.read_adc(0)
    # print(a_val)
    if a_val < 50:
        return True
    elif a_val > 250:
        return False
    else:
        return old_value

# Dimmer
def dimmer(value):
    global led_br
    # Dark
    if value:
        backlight.change_duty_cycle(70)
        led_br = 10
    # Bright
    else:
        backlight.change_duty_cycle(0)
        led_br = 80

if TEST_MODE is False:
    old_dark = is_dark(True)
    dimmer(old_dark)

# Return CPU temperature and CPU clock as a character string
def getCPUtemperature():
    temp = os.popen('vcgencmd measure_temp').readline()
    temp = temp.replace("temp=", "")
    return temp.replace("'C\n", "°C")
    # return "20"

def getCPUclock():
    clock = os.popen('vcgencmd measure_clock arm').readline()
    clock = clock.replace("frequency(48)=", "")
    clock = int(clock)/1000000
    return str(int(clock))
    # return "400"

def error_flags(number):
    # Convert to bit list
    bit_list = [True if x == "1" else False for x in "{:016b}".format(number)]
    # Get the errors that are on
    errors_on = []
    for x in range(len(bit_list)):
        if bit_list[x]:
            errors_on.append(ERRORFLAGS[x])
    return errors_on

# Reading 3 bit bitfield from Can extension board (message 0x610)
def bitfield_3_return(number):
    # Convert to bit list
    bit_list = [True if x == "1" else False for x in "{:03b}".format(number)]
    return bit_list

# Emu Black error flags
ERRORFLAGS = ("", "OILP", "EWG", "DSG", "DIFFCTRL", "FPR", "DBW", "FF_SENSOR",
              "KNOCKING", "EGT_ALARM", "EGT2", "EGT1", "WBO", "MAP", "IAT", "CLT")

title_text_units = {"rpm": "RPM", "tps": "TPS                 %",
                    "iat": "IAT                 °C", "map": "MAP              kPa",
                    "inj_pw": "Inj pw.           ms", "oil_t": "Oil temp.       °C",
                    "oil_p": "Oil press.      bar", "fuel_p": "Fuel press.    bar",
                    "clt_t": "Clt temp.       °C", "ign_ang": "Ign angle  °btdc",
                    "dwell": "Dwell time    ms", "lambda": "Lambda",
                    "lambda_corr": "Lambda corr.  %", "egt_1": "EGT 1             °C",
                    "egt_2": "EGT 2             °C", "batt_v": "Battery  voltage",
                    "ethanol_cont": "Ethanol           %", "dbw_pos": "Dbw position  %",
                    "boost_t": "Boost target  kPa", "dsg_mode": "DSG mode",
                    "lambda_t": "Lambda target", "fuel_used": "Fuel used         L",
                    "fuel_level": "Fuel level        %", "fuel_consum": "Fuel c.  L/100km"}

dsg_mode_return = {0: "0", 2: "P", 3: "R", 4: "N", 5: "D", 6: "S", 7: "M", 15: "Fault"}

font_20 = pygame.font.SysFont("dejavusans", int(20*scaley))
font_30 = pygame.font.SysFont("dejavusans", int(30*scaley))
font_60 = pygame.font.SysFont("dejavusans", int(60*scaley))
font_80 = pygame.font.SysFont("dejavusans", int(80*scaley))

# Text box sizes
digits_30 = [font_30.size("0"), font_30.size("00"), font_30.size("000")]
kmh_30 = font_30.size("km/h")
one_digit_60 = font_60.size("0")
three_digit_60 = font_60.size("000")
one_letter_60 = font_60.size("N")
digits_80 = [font_80.size("0"), font_80.size("00"), font_80.size("000"), font_80.size("0000"), font_80.size("00000"), font_80.size("000000")]

# Renders
CELSIUS_20 = font_20.render("°C", True, WHITE, BLACK)
KMH_TEXT = font_30.render("km/h", True, WHITE, BLACK)
NO_CAN_BUS_R = font_20.render("No Can Bus communication", True, WHITE, BLACK)
# RPM bar numbers
rpm_list = [font_60.render(str(x), True, WHITE) for x in range(1, 10)]

image0 = pygame.image.load(PATH + "High_beam_blue.png")
image1 = pygame.image.load(PATH + "High_beam_black.png")
image2 = pygame.image.load(PATH + "Fuel_pump_yellow.png")
image3 = pygame.image.load(PATH + "Fuel_pump_black.png")

HIGH_BEAM_BLUE = pygame.Surface.convert(image0)
HIGH_BEAM_BLACK = pygame.Surface.convert(image1)
FUEL_PUMP_YELLOW = pygame.Surface.convert(image2)
FUEL_PUMP_BLACK = pygame.Surface.convert(image3)

charRect = pygame.Rect((0,0),(50*scalex, 50*scaley))
# print os.path.abspath("airbender.png")
# charImage = pygame.image.load(os.path.abspath("ImageName.png"))
charImage = pygame.transform.scale(image0, charRect.size)
HIGH_BEAM_BLUE = charImage.convert()
charImage = pygame.transform.scale(image1, charRect.size)
HIGH_BEAM_BLACK = charImage.convert()
charImage = pygame.transform.scale(image2, charRect.size)
FUEL_PUMP_YELLOW = charImage.convert()
charImage = pygame.transform.scale(image3, charRect.size)
FUEL_PUMP_BLACK = charImage.convert()


unit_buttons = [pygame.Rect(0, 95*scaley, 180*scalex, 100*scaley), pygame.Rect(0, 210*scaley, 180*scalex, 100*scaley),
                pygame.Rect(0, 325*scaley, 180*scalex, 100*scaley), pygame.Rect(RIGHT_SIDE, 95*scaley, 180*scalex, 100*scaley),
                pygame.Rect(RIGHT_SIDE, 210*scaley, 180*scalex, 100*scaley), pygame.Rect(RIGHT_SIDE, 325*scaley, 180*scalex, 100*scaley)]

# Creating title texts
units_r = []
for x in range(6):
    units_r.append(font_20.render(title_text_units[units[x]], True, WHITE, BLACK))

while loop:
    try:
        for event in pygame.event.get():
            if event.type == pygame.KEYDOWN:
                loop = False
            elif event.type == pygame.MOUSEBUTTONDOWN:
                touch = True
                pos = event.pos
            elif event.type == pygame.FINGERUP:
                touch = True
                pos = touch_xy(event.x, event.y)

        if TEST_MODE is False:
            # Read can bus message
            message = can_bus.recv(timeout=1)
            # Shutdown if there is no Can Bus communication
            if message is None:
                clear = True
                countdown -= 1
                pygame.draw.rect(screen, BLACK, [CENTER_X - (150*scalex), 180*scaley, 300*scalex, 150*scaley], border_radius=10)
                screen.blit(NO_CAN_BUS_R, (CENTER_X - (140*scalex), CENTER_Y - (10*scaley)))
                shutdown = font_20.render("Shutting down in: " + str(countdown) + " s", True, WHITE, BLACK)
                screen.blit(shutdown, (CENTER_X - (140*scalex), CENTER_Y + (15*scaley)))
                pygame.display.flip()
                if countdown == 0:
                    power_off = True
                    break
                if loop:
                    continue
            else:
                data = message.data
                message_id = message.arbitration_id
                dlc = message.dlc
        if TEST_MODE or message is None:
            data = None
            message_id = None
            dlc = None
        # Reset shutdown countdown
        countdown = 10
        result =  ws.recv()    
        #   print(result)
        list = result.split()
        rpm = int(float(list[14]))
        speed_kph=  rpm / 10  #float(list[102])
        speed=  speed_kph / 1.6
        coolantRaw = float(list[7])
        coolant = coolantRaw - 40
        iatRaw = float(list[6])
        intake = iatRaw - 40
        load = list[10]
        throttle = list[24]
        if "rpm" in units:
            values["rpm"] = int(float(list[14]))
        if "tps" in units:
            values["tps"] = float(list[24])
        if "iat" in units:
            values["iat"] = float(list[6])
        if "map" in units:
            values["map"] = float(list[4])
        if "inj_pw" in units:
            values["inj_pw"] = float(list[75])
        speed = speed_kph
            # Odometer
        speed_sum += speed
        speed_sum_counter += 1
        if speed_sum_counter >= 100:
            # Calculating travelled distance and save it
            odometer = odometer_save(speed_sum, speed_sum_counter, distance_timer, odometer, PATH)
            distance_timer = time.monotonic()
            speed_sum = 0
            speed_sum_counter = 0
        if "oil_t" in units:
            values["oil_t"] = float(list[114])
        if "oil_p" in units:
            values["oil_p"] = float(list[106])
        if "fuel_p" in units:
            values["fuel_p"] = float(list[105])
        if "clt_t" in units:
            values["clt_t"] = float(list[7])
        if "ign_ang" in units:
            values["ign_ang"] = float(list[116])
        if "dwell" in units:
            values["dwell"] = float(list[89])
            # if "lambda" in units:
            #     values["lambda"] = round(message[2] * 0.0078125, 2)
            # if "lambda_corr" in units:
            #     values["lambda_corr"] = int(message[3] * 0.5)
            # if "egt_1" in units:
            #     values["egt_1"] = message[4]
            # if "egt_2" in units:
            #     values["egt_2"] = message[5]
        gear = float(list[104])
        batt_v = float(list[9])
        if "batt_v" in units:
            values["batt_v"] = batt_v
            # Error flags
            # errors = message[3]
            # if "ethanol_cont" in units:
            #     values["ethanol_cont"] = message[5]
            # if "boost_t" in units:
            #     values["boost_t"] = message[0]
            # if "dsg_mode" in units:
            #     values["dsg_mode"] = dsg_mode_return[message[2]]
            # if "lambda_t" in units:
            #     values["lambda_t"] = round(message[3] * 0.01, 2)
            # fuel_used = message[5] * 0.01
            # if "fuel_used" in units:
            #     values["fuel_used"] = round(fuel_used, 1)



        # List of what to update on the screen
        display_update = []
        # Clearing screen
        if clear:
            screen.fill((60, 60, 60))
            values = {x : 0 for x in units}
            old_values = {x : None for x in units}
            pygame.display.flip()

        if message_id == 0x400 and dlc == 3:
            message = struct.unpack("<BBb", data)
            bit_list_3 = bitfield_3_return(message[0])
            # High beam input is inverted
            high_beam = not bit_list_3[0]
            right_blinker = bit_list_3[1]
            left_blinker = bit_list_3[2]
            raw_fuel_level = message[1]
            out_temp = message[2]
            # Fuel level averaging
            if raw_fuel_level > FUEL_MAX:
                raw_fuel_level = FUEL_MAX
            elif raw_fuel_level < FUEL_MIN:
                raw_fuel_level = FUEL_MIN
            if filter_counter < 199:
                filter_sum += raw_fuel_level
                filter_counter += 1
                filter_ready = False
            else:
                fuel_level = int(filter_sum / filter_counter)
                filter_sum = 0
                filter_counter = 0
                filter_ready = True
            # Scaling and reading stabilation
            if filter_ready or start_up:
                # If filtering not ready
                if start_up:
                    fuel_level = raw_fuel_level
                fuel_level = int((fuel_level - FUEL_MIN) / FUEL_DIVIDER - 100)
                if fuel_level != 0:
                    fuel_level = fuel_level * -1
                if start_up is False and fuel_level > old_fuel_level:
                    fuel_level = old_fuel_level + 1
                elif start_up is False and fuel_level < old_fuel_level:
                    fuel_level = old_fuel_level - 1
                old_fuel_level = fuel_level
                start_up = False
            if "fuel_level" in units:
                values["fuel_level"] = fuel_level

        if message_id == ECU_CAN_ID and dlc == 8:
            # Unpack message
            message = struct.unpack("<HBbHH", data)
            rpm = message[0]
            if "rpm" in units:
                values["rpm"] = rpm
            if "tps" in units:
                values["tps"] = int(message[1] * 0.5)
            if "iat" in units:
                values["iat"] = message[2]
            if "map" in units:
                values["map"] = message[3]
            if "inj_pw" in units:
                values["inj_pw"] = round(message[4] * 0.016129, 1)

        elif message_id == ECU_CAN_ID + 2 and dlc == 8:
            message = struct.unpack("<HBBBBh", data)
            speed = message[0]
            # Odometer
            speed_sum += speed
            speed_sum_counter += 1
            if speed_sum_counter >= 100:
                # Calculating travelled distance and save it
                odometer = odometer_save(speed_sum, speed_sum_counter, distance_timer, odometer, PATH)
                distance_timer = time.monotonic()
                speed_sum = 0
                speed_sum_counter = 0
            if "oil_t" in units:
                values["oil_t"] = message[2]
            if "oil_p" in units:
                values["oil_p"] = round(message[3] * 0.0625, 1)
            if "fuel_p" in units:
                values["fuel_p"] = round(message[4] * 0.0625, 1)
            if "clt_t" in units:
                values["clt_t"] = message[5]

        elif message_id == ECU_CAN_ID + 3 and dlc == 8:
            message = struct.unpack("<bBBBHH", data)
            if "ign_ang" in units:
                values["ign_ang"] = message[0] * 0.5
            if "dwell" in units:
                values["dwell"] = round(message[1] * 0.05, 1)
            if "lambda" in units:
                values["lambda"] = round(message[2] * 0.0078125, 2)
            if "lambda_corr" in units:
                values["lambda_corr"] = int(message[3] * 0.5)
            if "egt_1" in units:
                values["egt_1"] = message[4]
            if "egt_2" in units:
                values["egt_2"] = message[5]

        elif message_id == ECU_CAN_ID + 4 and dlc == 8:
            message = struct.unpack("<BbHHBB", data)
            gear = message[0]
            batt_v = round(message[2] * 0.027, 1)
            if "batt_v" in units:
                values["batt_v"] = batt_v
            # Error flags
            errors = message[3]
            if "ethanol_cont" in units:
                values["ethanol_cont"] = message[5]

        elif message_id == ECU_CAN_ID + 5 and dlc == 8:
            message = struct.unpack("<BBhHBB", data)
            if "dbw_pos" in units:
                values["dbw_pos"] = int(message[0] * 0.5)

        elif message_id == ECU_CAN_ID + 7 and dlc == 8:
            message = struct.unpack("<HBBBBH", data)
            if "boost_t" in units:
                values["boost_t"] = message[0]
            if "dsg_mode" in units:
                values["dsg_mode"] = dsg_mode_return[message[2]]
            if "lambda_t" in units:
                values["lambda_t"] = round(message[3] * 0.01, 2)
            fuel_used = message[5] * 0.01
            if "fuel_used" in units:
                values["fuel_used"] = round(fuel_used, 1)

        if clear or int(odometer) != int(old_odometer):
            trip = odometer - odometer_start
            if fuel_used != 0 and trip != 0:
                fuel_consum = round(fuel_used / ((trip) / 100), 1)
                if "fuel_consum" in units:
                    values["fuel_consum"] = fuel_consum

        # Shift light
        # Shift light
        if rpm > END - STEP * 5:
            # shift_light_v2.action(rpm, STEP, END, led_br)
            shift_light_off = False
            # Make sure all leds are off
        else:
            if shift_light_off is False:
                # shift_light_v2.leds_off()
                shift_light_off = True

        # Dimmer (10Hz update rate from ADC)
        # if time.monotonic() > dimmer_timer_1:
        #     dimmer_timer_1 = time.monotonic() + .1
        #     dark = is_dark(old_dark)
        #     # If ambient light hasn't changed: reset timer
        #     if dark is old_dark:
        #         dimmer_timer_4 = time.monotonic() + 4
        #     # If timer hasn't been reseted in 4 seconds: change brightness
        #     if time.monotonic() > dimmer_timer_4:
        #         dimmer(dark)
        #         old_dark = dark

        # To make sure a unit button is pressed in menu
        if units_ok:
            # Update values, when needed
            # Top left value update
            if values[units[0]] != old_values[units[0]] or clear:
                pygame.draw.rect(screen, BLACK, [0, 95*scaley, 180*scalex, 100*scaley], border_radius=10)
                value_0_r = font_60.render(str(values[units[0]]), True, WHITE, BLACK)
                screen.blit(value_0_r, (10*scalex, 125*scaley))
                screen.blit(units_r[0], (10*scalex, 100*scaley))
                display_update.append((0, 95*scaley, 180*scalex, 100*scaley))
            # Center left value update
            if values[units[1]] != old_values[units[1]] or clear:
                pygame.draw.rect(screen, BLACK, [0, 210*scaley, 180*scalex, 100*scaley], border_radius=10)
                value_1_r = font_60.render(str(values[units[1]]), True, WHITE, BLACK)
                screen.blit(value_1_r, (10*scalex, 240*scaley))
                screen.blit(units_r[1], (10*scalex, 215*scaley))
                display_update.append((0, 210*scaley, 180*scalex, 100*scaley))
            # Bottom left value update
            if values[units[2]] != old_values[units[2]] or clear:
                pygame.draw.rect(screen, BLACK, [0, 325*scaley, 180*scalex, 100*scaley], border_radius=10)
                value_2_r = font_60.render(str(values[units[2]]), True, WHITE, BLACK)
                screen.blit(value_2_r, (10*scalex, 355*scaley))
                screen.blit(units_r[2], (10*scalex, 330*scaley))
                display_update.append((0, 325*scaley, 180*scalex, 100*scaley))
            # Top right value update
            if values[units[3]] != old_values[units[3]] or clear:
                pygame.draw.rect(screen, BLACK, [RIGHT_SIDE, 95*scaley, 180*scalex, 100*scaley], border_radius=10)
                value_3_r = font_60.render(str(values[units[3]]), True, WHITE, BLACK)
                screen.blit(value_3_r, (RIGHT_SIDE + 10*scalex, 125*scaley))
                screen.blit(units_r[3], (RIGHT_SIDE + 10*scalex, 100*scaley))
                display_update.append((RIGHT_SIDE, 95*scaley, 180*scalex, 100*scaley))
            # Center right value update
            if values[units[4]] != old_values[units[4]] or clear:
                pygame.draw.rect(screen, BLACK, [RIGHT_SIDE, 210*scaley, 180*scalex, 100*scaley], border_radius=10)
                value_4_r = font_60.render(str(values[units[4]]), True, WHITE, BLACK)
                screen.blit(value_4_r, (RIGHT_SIDE + 10*scalex, 240*scaley))
                screen.blit(units_r[4], (RIGHT_SIDE + 10*scalex, 215*scaley))
                display_update.append((RIGHT_SIDE, 210*scaley, 180*scalex, 100*scaley))
            # Bottom right value update
            if values[units[5]] != old_values[units[5]] or clear:
                pygame.draw.rect(screen, BLACK, [RIGHT_SIDE, 325*scaley, 180*scalex, 100*scaley], border_radius=10)
                value_5_r = font_60.render(str(values[units[5]]), True, WHITE, BLACK)
                screen.blit(value_5_r, (RIGHT_SIDE + 10*scalex, 355*scaley))
                screen.blit(units_r[5], (RIGHT_SIDE + 10*scalex, 330*scaley))
                display_update.append((RIGHT_SIDE, 325*scaley, 180*scalex, 100*scaley))
            # Save old values
            for x in range(6):
                if values[units[x]] != old_values[units[x]] or clear is True:
                    old_values[units[x]] = values[units[x]]

        # Gear update
        if gear != old_gear or clear:
            pygame.draw.rect(screen, BLACK, [CENTER_X - (40*scalex), 90*scaley, 80*scalex, 80*scaley], border_radius=10)
            old_gear = gear
            if gear == 0:
                gear = "N"
            gear_r = font_60.render(str(gear), True, WHITE, BLACK)
            if gear == "N":
                screen.blit(gear_r, (CENTER_X - (one_letter_60[0] / 2)*scalex, 95*scaley))
            else:
                screen.blit(gear_r, (CENTER_X - (one_digit_60[0] / 2)*scalex, 95*scaley))
            display_update.append((CENTER_X - 40*scalex, 90*scaley, 80*scalex, 80*scaley))
        # Speed update
        if speed != old_speed or clear:
            old_speed = speed
            pygame.draw.rect(screen, BLACK, [CENTER_X - 110*scalex, 180*scaley, 220*scalex, 150*scaley], border_radius=10)
            speed_r = font_80.render(str(speed), True, WHITE, BLACK)
            screen.blit(speed_r, (CENTER_X - (digits_80[len(str(speed)) - 1][0] / 2), CENTER_Y - digits_80[0][1] / 2))
            screen.blit(KMH_TEXT, (CENTER_X - kmh_30[0] / 2*scalex, 285*scaley))
            display_update.append((CENTER_X - 110*scalex, 180*scaley, 220*scalex, 150*scaley))

        clock = time.strftime("%H:%M")
        if clock != old_clock or out_temp != old_out_temp or int(odometer) != int(old_odometer) or clear:
            pygame.draw.rect(screen, BLACK, [CENTER_X - 110*scalex, 340*scaley, 220*scalex, 80*scaley], border_radius=10)
            screen.blit(CELSIUS_20, (CENTER_X + 75*scalex, 350*scaley))
            # Clock update
            old_clock = clock
            clock_r = font_30.render(clock, True, WHITE, BLACK)
            screen.blit(clock_r, (CENTER_X - 100*scalex, 343*scaley))
            # Out temp update
            old_out_temp = out_temp
            out_temp_r = font_30.render(str(out_temp), True, WHITE, BLACK)
            out_temp_location = CENTER_X + (72 - digits_30[len(str(out_temp)) - 1][0])*scalex, 343*scaley
            if out_temp < 0:
                out_temp_location = out_temp_location[0] + 7,  343*scaley
            screen.blit(out_temp_r, out_temp_location)
            # Odometer update
            old_odometer = odometer
            odometer_r = font_30.render(str(int(odometer)) + " km", True, WHITE, BLACK)
            screen.blit(odometer_r, (CENTER_X - 100*scalex, 383*scaley))
            display_update.append((CENTER_X - 110*scalex, 340*scaley, 220*scalex, 80*scaley))

        # RPM Bar
        if rpm != old_rpm or clear:
            rpm_bar = int(rpm * 0.08)
            pygame.draw.rect(screen, BLACK, (0, 0, 800*scalex, 80*scaley))
            # pygame.draw.rect(screen, LIGHT_BLUE, (0, 0, rpm_bar*scalex, 80*scaley))
            if rpm < SHIFTONE:
                pygame.draw.rect(screen, LIGHT_BLUE, (0, 0, rpm_bar*scalex, 80*scaley))
            elif rpm < SHIFTTWO:
                pygame.draw.rect(screen, YELLOW, (0, 0, rpm_bar*scalex, 80*scaley))
            elif rpm < SHIFTTHREE:
                pygame.draw.rect(screen, ORANGE, (0, 0, rpm_bar*scalex, 80*scaley))
            elif rpm < MAX:
                pygame.draw.rect(screen, RED, (0, 0, rpm_bar*scalex, 80*scaley))
            # if shift_light_off is True:        
            #     pygame.draw.rect(screen, LIGHT_BLUE, (0, 0, rpm_bar*scalex, 80*scaley))
            # else:
            #     pygame.draw.rect(screen, RED, (0, 0, rpm_bar*scalex, 80*scaley))
            for x in range(len(rpm_list)):
                screen.blit(rpm_list[x], ((width / 10 * (x + 1) - one_digit_60[0] / 2), (40 - one_digit_60[1] / 2)*scaley))
            old_rpm = rpm
            display_update.append((0, 0, 800*scalex, 80*scaley))

        if old_left_blinker != left_blinker or clear:
            if left_blinker:
                blinker_colour = GREEN
            else:
                blinker_colour = BLACK
            bl = [210, 150]
            pygame.draw.polygon(screen, blinker_colour, [[bl[0]*scalex, bl[1]*scaley], [(bl[0] + 16)*scalex, (bl[1] - 16)*scaley], [(bl[0] + 16)*scalex, (bl[1] + 16)*scaley]])
            pygame.draw.rect(screen, blinker_colour, ((bl[0] + 16)*scalex, (bl[1] - 8)*scaley, 16*scalex, 16*scaley))
            old_left_blinker = left_blinker
            display_update.append(((bl[0] - 1)*scalex, (bl[1] - 17)*scaley, 34*scalex, 34*scaley))

        if old_right_blinker != right_blinker or clear:
            if right_blinker:
                blinker_colour = GREEN
            else:
                blinker_colour = BLACK
            br = [590, 150]
            pygame.draw.polygon(screen, blinker_colour, [[br[0]*scalex, br[1]*scaley], [(br[0] - 16)*scalex, (br[1] - 16)*scaley], [(br[0] - 16)*scalex, (br[1] + 16)*scaley]])
            pygame.draw.rect(screen, blinker_colour, ((br[0] - 32)*scalex, (br[1] - 8)*scaley, 16*scalex, 16*scaley))
            old_right_blinker = right_blinker
            display_update.append(((br[0] - 33)*scalex, (bl[1] - 17)*scaley, 34*scalex, 34*scaley))

        if old_high_beam != high_beam or clear:
            if high_beam:
                screen.blit(HIGH_BEAM_BLUE, (205*scalex, 350*scaley))
            else:
                screen.blit(HIGH_BEAM_BLACK, (205*scalex, 350*scaley))
            old_high_beam = high_beam
            display_update.append((205*scalex, 350*scalex, 50*scalex, 50*scalex))

        # Fuel level warning
        if fuel_level is not None and fuel_level < 6:
            refuel = True
        elif fuel_level is not None and fuel_level > 10:
            refuel = False

        if refuel != old_refuel or clear:
            if refuel is False:
                screen.blit(FUEL_PUMP_BLACK, (545*scalex, 350*scaley))
            else:
                screen.blit(FUEL_PUMP_YELLOW, (545*scalex, 350*scaley))
            old_refuel = refuel
            display_update.append((545*scalex, 350*scaley, 50*scalex, 50*scaley))

        # Errors
        error_list = []
        if errors != 0:
            error_list = error_flags(errors)

        # Battery voltage low warning
        if batt_v < 11.3 or batt_v < 13 and rpm > 0:
            error_list.append("Battery " + str(batt_v) + "V")

        # 1Hz update rate on cpu statistics
        if error_list != old_error_list or cpu_timer < time.monotonic() or clear:
            cpu_timer = time.monotonic() + 1
            if len(error_list) == 0:
                pygame.draw.rect(screen, LIGHT_BLUE, (0, 440*scaley, 800*scalex, 40*scaley))
                cpu_temp = getCPUtemperature()
                cpu_clock = getCPUclock()
                # Showing ADC just for testing
                cpu_stats_text = font_30.render("Cpu: " + cpu_temp + ", " + cpu_clock +
                                                " MHz", True, WHITE, LIGHT_BLUE)
                screen.blit(cpu_stats_text, (0, 443*scaley))
            else:
                errors_text = font_30.render("Errors " + str(len(error_list)) + ": ", True, WHITE, RED)
                errors_r = font_30.render(", ".join(error_list), True, WHITE, RED)
                pygame.draw.rect(screen, RED, (0, 440*scaley, 800*scalex, 40*scaley))
                screen.blit(errors_text, (0, 443*scaley))
                screen.blit(errors_r, (135*scalex, 443*scaley))
            old_error_list = error_list
            clear = False
            display_update.append((0, 440*scaley, 800*scalex, 40*scaley))

        if touch:
            # Pick a new unit from menu
            for x in range(6):
                if unit_change == x:
                    units[x] = menu(pos)
                    if units[x] is not None:
                        units_r[x] = font_20.render(title_text_units[units[x]], True, WHITE, BLACK)
                        unit_change = None
                        clear = True
                        units_ok = True
                    else:
                        units_ok = False
            # Enable menu draw
            for x in range(6):
                if clear is False and pygame.Rect.collidepoint(unit_buttons[x], pos):
                    draw_menu = True
                    unit_change = x
            touch = False

            # Saving to memory
            if clear:
                units_memory = open(PATH + "units_memory.txt", "w")
                for x in range(len(units)):
                    units_memory.write(str(units[x]) + "\n")
                units_memory.close()

        if draw_menu:
            screen.fill((60, 60, 60))

            def create_rect(x, y, text):
                pygame.draw.rect(screen, BLACK, [x, y, 190, 70], border_radius=10)
                name = font_20.render(text, True, WHITE)
                screen.blit(name, (x + 15, y + 20))
                return pygame.Rect(x, y, 190, 70)

            # Coordinates
            coordinates_x = []
            coordinates_y = []
            coordinate_y = 5
            coordinate_x = 5
            for x in range(6):
                coordinates_y.append(coordinate_y)
                coordinate_y += 80
            for x in range(4):
                coordinates_x.append(coordinate_x)
                coordinate_x += 200

            # Buttons
            rpm_button = create_rect(coordinates_x[0], coordinates_y[0], "RPM")
            tps_button = create_rect(coordinates_x[1], coordinates_y[0], "TPS")
            iat_button = create_rect(coordinates_x[2], coordinates_y[0], "IAT")
            map_button = create_rect(coordinates_x[3], coordinates_y[0], "MAP")
            inj_pw_button = create_rect(coordinates_x[0], coordinates_y[1], "Inj pw.")
            oil_t_button = create_rect(coordinates_x[1], coordinates_y[1], "Oil temp.")
            oil_p_button = create_rect(coordinates_x[2], coordinates_y[1], "Oil pressure")
            fuel_p_button = create_rect(coordinates_x[3], coordinates_y[1], "Fuel pressure")
            clt_t_button = create_rect(coordinates_x[0], coordinates_y[2], "Coolant temp.")
            ign_ang_button = create_rect(coordinates_x[1], coordinates_y[2], "Ignition angle")
            dwell_button = create_rect(coordinates_x[2], coordinates_y[2], "Dwell time")
            lambda_button = create_rect(coordinates_x[3], coordinates_y[2], "Lambda")
            lambda_corr_button = create_rect(coordinates_x[0], coordinates_y[3], "Lambda corr.")
            egt_1_button = create_rect(coordinates_x[1], coordinates_y[3], "EGT 1")
            egt_2_button = create_rect(coordinates_x[2], coordinates_y[3], "EGT 2")
            batt_v_button = create_rect(coordinates_x[3], coordinates_y[3], "Battery voltage")
            ethanol_cont_button = create_rect(coordinates_x[0], coordinates_y[4], "Ethanol content")
            dbw_pos_button = create_rect(coordinates_x[1], coordinates_y[4], "Dbw position")
            boost_t_button = create_rect(coordinates_x[2], coordinates_y[4], "Boost target")
            dsg_mode_button = create_rect(coordinates_x[3], coordinates_y[4], "DSG Mode")
            lambda_t_button = create_rect(coordinates_x[0], coordinates_y[5], "Lambda target")
            fuel_used_button = create_rect(coordinates_x[1], coordinates_y[5], "Fuel used")
            fuel_level_button = create_rect(coordinates_x[2], coordinates_y[5], "Fuel level")
            fuel_consumption_button = create_rect(coordinates_x[3], coordinates_y[5], "Fuel consum.")

            pygame.display.flip()
            draw_menu = False

        # Update screen
        if unit_change is None:
            pygame.display.update(display_update)
    except Exception as e:
        print("Error: "+str(e))
        print(e.with_traceback)

# Close the program
odometer = odometer_save(speed_sum, speed_sum_counter, distance_timer, odometer, PATH)
pygame.quit()
if TEST_MODE is False:
    close_io()
if power_off:
    print("Shutdown")
    os.system("shutdown -h now")
