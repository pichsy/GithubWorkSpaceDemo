package com.example.apkdownloader;

public class DownloadTask {
    private String downloadUrl;
    private String filePath;
    private int bufferSize;
    private int retryCount;

    private DownloadTask(Builder builder) {
        this.downloadUrl = builder.downloadUrl;
        this.filePath = builder.filePath;
        this.bufferSize = builder.bufferSize;
        this.retryCount = builder.retryCount;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public String getFilePath() {
        return filePath;
    }

    public int getBufferSize() {
        return bufferSize;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public static class Builder {
        private String downloadUrl;
        private String filePath;
        private int bufferSize = 1024; // Default buffer size
        private int retryCount = 3; // Default retry count

        public Builder setDownloadUrl(String downloadUrl) {
            this.downloadUrl = downloadUrl;
            return this;
        }

        public Builder setFilePath(String filePath) {
            this.filePath = filePath;
            return this;
        }

        public Builder setBufferSize(int bufferSize) {
            this.bufferSize = bufferSize;
            return this;
        }

        public Builder setRetryCount(int retryCount) {
            this.retryCount = retryCount;
            return this;
        }

        public DownloadTask build() {
            return new DownloadTask(this);
        }
    }
}
