def call(String path, boolean cleanDir = false) {
powershell """
    Write-Host 'Creating directory: ${path}'
    New-Item -ItemType Directory -Force -Path '${path}' -ErrorAction Stop
"""
}