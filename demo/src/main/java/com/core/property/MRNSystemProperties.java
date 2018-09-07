package fr.co.mybus.mrn.common.core.property;

import org.apache.log4j.Logger;

public class MRNSystemProperties 
{
	static Logger log = Logger.getLogger(MRNSystemProperties.class);
	
//	private static ResourceBundle resources;
//
//    static {
//        try {
//           
//                resources = ResourceBundle.getBundle("MRNSystem");            
//            
//        }
//        catch (Exception ex) {
//            log.error("Faild to get Property File.", ex);
//        }
//    }
    
    
    /**
     * Server Id
     */
    private static String SERVER_ID ;
    /**
     * TDS.SUPPLIER.URL
     */
    private static String TDS_SUPPLIER_URL ;
    
    
    private static String BOOKME_URL ;
    
    private static String WS0101_XSD_PATH ;
    private static String WS0102_XSD_PATH ;
    private static String WS0103_XSD_PATH ;
    
    private static String MAIL_SERVER_HOST;
    
    private static String SEND_MAIL_OUT_FLG;
    
    private static String ADMIN_MAIL_ADDRESS;
    
    private static String MAIL_SERVER_PORT;
    
    private static String ATTACHMENT_PATH;
    private static String RESERVATION_ATTACHMENT_PATH;
    
    private static String ONLINE_CONFIRMATION_URL;
    
    private static String TASK_NOTIFICATION;
    
    /**
     * @param serverId
     */
    public static void setMRNSystemProperties(String serverId,String tdsSupplierURL, String bookMeUrl,String ws0101XSDPath,String mailServerHost,
    		String serverPort,String mailFlag,String adminMailAddress,String attachmentPath,
    		String onlineConfirmationUrl,String ws0102XSDPath,String reservationAttachmentPath, String taskNotification,String ws0103XSDPath)
    {
    	SERVER_ID = serverId;
    	TDS_SUPPLIER_URL=tdsSupplierURL;
    	BOOKME_URL = bookMeUrl;
    	WS0101_XSD_PATH=ws0101XSDPath;
    	MAIL_SERVER_HOST=mailServerHost;
    	SEND_MAIL_OUT_FLG=mailFlag;
    	ADMIN_MAIL_ADDRESS=adminMailAddress;
    	MAIL_SERVER_PORT=serverPort;
    	ATTACHMENT_PATH=attachmentPath;
    	RESERVATION_ATTACHMENT_PATH=reservationAttachmentPath;
    	ONLINE_CONFIRMATION_URL=onlineConfirmationUrl;
    	WS0102_XSD_PATH=ws0102XSDPath;
    	TASK_NOTIFICATION = taskNotification;
    	WS0103_XSD_PATH=ws0103XSDPath;
    }

	public static String getSERVER_ID() {
		return SERVER_ID;
	}

	public static String getTDS_SUPPLIER_URL() {
		return TDS_SUPPLIER_URL;
	}

	public static String getBOOKME_URL() {
		return BOOKME_URL;
	}

	public static String getWS0101_XSD_PATH() {
		return WS0101_XSD_PATH;
	}

	/**
	 * @return the log
	 */
	public static Logger getLog() {
		return log;
	}

	/**
	 * @return the mAIL_SERVER_HOST
	 */
	public static String getMAIL_SERVER_HOST() {
		return MAIL_SERVER_HOST;
	}

	/**
	 * @return the sEND_MAIL_OUT_FLG
	 */
	public static String getSEND_MAIL_OUT_FLG() {
		return SEND_MAIL_OUT_FLG;
	}

	/**
	 * @return the aDMIN_MAIL_ADDRESS
	 */
	public static String getADMIN_MAIL_ADDRESS() {
		return ADMIN_MAIL_ADDRESS;
	}

	/**
	 * @return the mAIL_SERVER_PORT
	 */
	public static String getMAIL_SERVER_PORT() {
		return MAIL_SERVER_PORT;
	}

	/**
	 * @return the aTTACHMENT_PATH
	 */
	public static String getATTACHMENT_PATH() {
		return ATTACHMENT_PATH;
	}

	/**
	 * @return the oNLINE_CONFIRMATION_URL
	 */
	public static String getONLINE_CONFIRMATION_URL() {
		return ONLINE_CONFIRMATION_URL;
	}

	public static String getWS0102_XSD_PATH() {
		return WS0102_XSD_PATH;
	}

	public static void setWS0102_XSD_PATH(String ws0102_xsd_path) {
		WS0102_XSD_PATH = ws0102_xsd_path;
	}

	public static String getRESERVATION_ATTACHMENT_PATH() {
		return RESERVATION_ATTACHMENT_PATH;
	}

	public static void setRESERVATION_ATTACHMENT_PATH(String rESERVATION_ATTACHMENT_PATH) {
		RESERVATION_ATTACHMENT_PATH = rESERVATION_ATTACHMENT_PATH;
	}

	public static String getTASK_NOTIFICATION() {
		return TASK_NOTIFICATION;
	}

	public static String getWS0103_XSD_PATH() {
		return WS0103_XSD_PATH;
	}

	public static void setWS0103_XSD_PATH(String ws0103_xsd_path) {
		WS0103_XSD_PATH = ws0103_xsd_path;
	}



    
    
    

}
