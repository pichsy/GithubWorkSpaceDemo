package com.example.apkdownloader;

import java.util.ArrayList;
import java.util.List;

public class DownloadManager {
    private List<DownloadTask> downloadQueue;
    private List<ProgressListener> progressListeners;

    public DownloadManager() {
        downloadQueue = new ArrayList<>();
        progressListeners = new ArrayList<>();
    }

    public void addDownloadTask(DownloadTask task) {
        downloadQueue.add(task);
        notifyProgressListeners(0);
    }

    public void removeDownloadTask(DownloadTask task) {
        downloadQueue.remove(task);
        notifyProgressListeners(0);
    }

    public void startDownload(DownloadTask task) {
        // Implement download logic here
        // Notify progress listeners during the download process
    }

    public void addProgressListener(ProgressListener listener) {
        progressListeners.add(listener);
    }

    public void removeProgressListener(ProgressListener listener) {
        progressListeners.remove(listener);
    }

    private void notifyProgressListeners(int progress) {
        for (ProgressListener listener : progressListeners) {
            listener.onProgress(progress);
        }
    }

    public List<DownloadTask> getDownloadQueue() {
        return downloadQueue;
    }

    public void setDownloadQueue(List<DownloadTask> downloadQueue) {
        this.downloadQueue = downloadQueue;
    }
}
