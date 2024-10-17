package com.example.apkdownloader

class DownloadManager {
    private val downloadQueue: MutableList<DownloadTask> = mutableListOf()
    private val progressListeners: MutableList<ProgressListener> = mutableListOf()

    fun addDownloadTask(task: DownloadTask) {
        downloadQueue.add(task)
        notifyProgressListeners(0)
    }

    fun removeDownloadTask(task: DownloadTask) {
        downloadQueue.remove(task)
        notifyProgressListeners(0)
    }

    fun startDownload(task: DownloadTask) {
        // Implement download logic here
        // Notify progress listeners during the download process
    }

    fun addProgressListener(listener: ProgressListener) {
        progressListeners.add(listener)
    }

    fun removeProgressListener(listener: ProgressListener) {
        progressListeners.remove(listener)
    }

    private fun notifyProgressListeners(progress: Int) {
        for (listener in progressListeners) {
            listener.onProgress(progress)
        }
    }

    fun getDownloadQueue(): List<DownloadTask> {
        return downloadQueue
    }

    fun setDownloadQueue(downloadQueue: MutableList<DownloadTask>) {
        this.downloadQueue = downloadQueue
    }
}
