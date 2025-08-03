import serial

s = serial.Serial(port='COM3',
      baudrate=38400,
      parity=serial.PARITY_NONE,
      stopbits=serial.STOPBITS_ONE,
      bytesize=serial.EIGHTBITS,
    )
res = s.read()
print(res)
