# server/preprocess_ini.py

def dedupe_and_load(path):
    lines = open(path).read().splitlines()
    seen = {}
    output = []
    current_section = None

    for line in lines:
        stripped = line.strip()
        if stripped.startswith('[') and stripped.endswith(']'):
            current_section = stripped
            seen[current_section] = {}
            output.append(line)
        elif '=' in line and current_section:
            key = stripped.split('=', 1)[0].strip()
            count = seen[current_section].get(key, 0) + 1
            seen[current_section][key] = count

            # On first occurrence, keep the key; thereafter append _<n>
            if count > 1:
                key_mod = f"{key}_{count}"
                val = line.split('=',1)[1]
                output.append(f"{key_mod}={val}")
            else:
                output.append(line)
        else:
            output.append(line)

    # Feed the modified text into a ConfigParser
    from configparser import ConfigParser
    cfg = ConfigParser()
    cfg.read_string('\n'.join(output))
    return cfg