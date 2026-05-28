def cmd = ['cmd', '/c', "if not exist \"${path}\" mkdir \"${path}\""]
def proc = new ProcessBuilder(cmd)
    .directory(new File(env.WORKSPACE))
    .redirectErrorStream(true)
    .start()
proc.waitForOrKill(120_000) // 2 минуты
if (proc.exitValue() != 0) {
    error(proc.inputStream.text)
}