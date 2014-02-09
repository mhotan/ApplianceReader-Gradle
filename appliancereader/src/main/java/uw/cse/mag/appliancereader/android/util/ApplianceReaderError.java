package org.uw.cse.mag.ar.util;

/**
 * General class that represents the error throwable for this application.
 *
 * @author - Michael Hotan, michael.hotan@gmail.com
 */
public class ApplianceReaderError extends Throwable {

    private static final long serialVersionUID = 1L;
    private int mErrorCode = 0;

    /**
     * Flag allowing the use of {@link #log()} method.
     * <p>
     * If true, calling the {@link #log()} method will print a full
     * stack trace in Logcat. Otherwise, this method is a no-op.
     * <p>
     * It is advised to set this flag to false before switching to production!
     */
    public static final boolean DEBUG = true;

    /**
     * Enum listing the possible errors.
     */
    public static final class Code {
        /** Success */
        public static final int SUCCESS = 0;
        /** Unspecified error */
        public static final int ERROR = 1;
        /** Invalid use of the library */
        public static final int MISUSE = 2;
        /** Access permission denied */
        public static final int NOPERM = 3;
        /** File not found */
        public static final int NOFILE = 4;
        /** Database file locked */
        public static final int BUSY = 5;
        /** Database file corrupted */
        public static final int CORRUPT = 6;
        /** Empty database */
        public static final int EMPTY = 7;
        /** Authorization denied */
        public static final int AUTH = 8;
        /** No internet connection */
        public static final int NOCONN = 9;
        /** Operation timeout */
        public static final int TIMEOUT = 10;
        /** Threading error */
        public static final int THREAD = 11;
        /** Credentials mismatch */
        public static final int CREDMISMATCH = 12;
        /** Internet connection too slow */
        public static final int SLOWCONN = 13;
        /** Record not found */
        public static final int NOREC = 14;
        /** Operation aborted */
        public static final int ABORT = 15;
        /** Resource temporarily unavailable */
        public static final int UNAVAIL = 16;
        /** Image size or format not supported */
        public static final int IMG = 17;
        /** Wrong API key or no offline image */
        public static final int APIKEY = 18;
    }

    /**
     * Constructor
     * @param message The error message
     * @param code    The error code
     */
    public ApplianceReaderError(String message, int code) {
        super(message);
        mErrorCode = code;
    }

    /**
     * Get the error code
     * @return  the error code among the {@link ApplianceReaderError.Code} flags.
     */
    public int getErrorCode() {
        return mErrorCode;
    }

    /**
     * Logs an error and its stack, if {@link #DEBUG} is true.
     */
    public void log() {
        if (DEBUG) printStackTrace();
    }

}
