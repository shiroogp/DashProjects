import configparsermultiopt

config = configparsermultiopt.ConfigParserMultiOpt()
config.read('FILE.INI')
print(config['OutputChannels']['status1'])     # -> "/path/name/"
for k, v in config['OutputChannels'].items():
    print(k, v)
# config['DEFAULT']['path'] = '/var/shared/'    # update
# config['DEFAULT']['default_message'] = 'Hey! help me!!'   # create

# with open('FILE.INI', 'w') as configfile:    # save
#     config.write(configfile)