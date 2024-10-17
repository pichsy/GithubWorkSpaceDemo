package com.example.apkdownloader

class DownloadTask private constructor(
    val downloadUrl: String,
    val filePath: String,
    val bufferSize: Int,
    val retryCount: Int
) {
    class Builder {
        private var downloadUrl: String = ""
        private var filePath: String = ""
        private var bufferSize: Int = 1024 // Default buffer size
        private var retryCount: Int = 3 // Default retry count

        fun setDownloadUrl(downloadUrl: String) = apply { this.downloadUrl = downloadUrl }
        fun setFilePath(filePath: String) = apply { this.filePath = filePath }
        fun setBufferSize(bufferSize: Int) = apply { this.bufferSize = bufferSize }
        fun setRetryCount(retryCount: Int) = apply { this.retryCount = retryCount }

        fun build(): DownloadTask {
            return DownloadTask(downloadUrl, filePath, bufferSize, retryCount)
        }
    }
}
