import os
from configparser import ConfigParser

def load_ecu_definitions(vendor_dir):
    """
    Scan vendor_dir for all .ini files and return
    a dict: {ecu_name: {signal_key: signal_props}}
    """
    all_defs = {}
    for fname in os.listdir(vendor_dir):
        if fname.lower().endswith('.ini'):
            path = os.path.join(vendor_dir, fname)
            cfg = ConfigParser(allow_no_value=True, strict=False)
            cfg.read(path)

            signals = {}
            for section in cfg.sections():
                if section.lower().startswith('signal_'):
                    sec = cfg[section]
                    signals[section] = {
                        'message_id': int(sec.get('MessageID', '0'), 0),
                        'start_bit':  int(sec.get('StartBit',    '0')),
                        'bit_length': int(sec.get('BitLength',   '0')),
                        'scale':      float(sec.get('Scale',      '1')),
                        'offset':     float(sec.get('Offset',     '0')),
                        'unit':       sec.get('Unit',            ''),
                    }
            all_defs[fname] = signals
    return all_defs

if __name__ == '__main__':
    base = os.path.join(os.path.dirname(__file__), '../ecudefs/coreefi')
    defs = load_ecu_definitions(base)
    print(f"Loaded {len(defs)} INI files. Sample signals:\n", defs)