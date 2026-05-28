def call(String path, boolean cleanDir = false) {
    if (!path?.trim()) error("mkdir: path is empty")
    
    if (cleanDir && fileExists(path)) {
        dir(path) { deleteDir() }
    }
    
    if (isUnix()) {
        sh "mkdir -p '${path}'"
    } else {
        // Таймаут 2 минуты — чтобы не держать очередь
        timeout(time: 2, unit: 'MINUTES') {
            echo "DEBUG: перед mkdir, path = '${path}'"
            bat "@if not exist \"${path}\" mkdir \"${path}\""
            echo "DEBUG: после mkdir"
        }
    }
}