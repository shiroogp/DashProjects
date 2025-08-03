import eel

eel.init("web")

@eel.expose
def change_text():
    new_text = "Text has been changed!"
    return new_text

eel.start("index.html")