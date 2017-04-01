package com.comcast.orderlab.config;

public class Configurations {
	
	public static final String TestSite="https://www.salesspace.comcast.com/orderlab";
	public static final String browser="Chrome";
	
	//login
	public static final String signin = "//*[@id=\"submitButton\"]";
	public static final String username="//*[@id=\"username\"]";
	public static final String password="//*[@id=\"password\"]";
	public static final String errorMsg="//*[@id=\"validation-errors\"]/ul/li";

	//SeachAddress
	public static final String start= "//*[@id=\"newOrder\"]/span";
	public static final String confirm ="//*[@id=\"overlay-newOrderDiv\"]/div[2]/div[3]/div[2]/a[1]";
	public static final String stAddress="//*[@id=\"address1\"]";
	public static final String apt= "//*[@id=\"apt\"]";
	public static final String zip="//*[@id=\"zip\"]";
	public static final String searchInput ="//*[@id=\"searchInputBtn\"]";
	public static final String menu = "//*[@id=\"dropdownListRightId\"]/a/div/div";
	public static final String signOut = "//*[@id=\"signOut\"]";
	public static final String dealFinder= "//*[@id=\"GoDealFinder\"]/span";

	//Select Landing Page
	public static final String selectNC= "//*[@id=\"newCustomerFlow\"]";

	//Select Offers-select data/video/voice
	public static final String selectData="//*[@id=\"ButtonINTERNET\"]";
	public static final String selectVoice= "//*[@id=\"ButtonVOICE\"]";
	public static final String selectVideo= "//*[@id=\"ButtonTV\"]";
	public static final String selectHome= "//*[@id=\"ButtonHomeOffers\"]";
	public static final String ShowOffers= "//*[@id=\"callOffers\"]";

	//Select Offers-Data
	public static final String X1ExconomyPlus="//*[@id=\"linkTVSelectAndCustomize1\"]";
	public static final String Extreme105Internet="//*[@id=\"linkTVSelectAndCustomize1\"]";
	

	//AddOnData
	public static final String InternetOptions="//*[@id=\"nav-bar-HIGH_SPEED_DATA\"]/a/span";
	public static final String LeaseModemRad = "//*[@id=\"choice_1_1\"]/div[2]/span[1]";
	public static final String OwnedModemRad = "//*[@id=\"choice_1_2\"]/div[2]/span[1]";
	public static final String AddOnNext ="//*[@id=\"gotoChannelOpt\"]";
	public static final String DeviceNext="//*[@id=\"gotoChannelOpt\"]";
	
	//Lease
	public static final String WorkListRad="//*[@id=\"choice_1_2\"]/div[2]/span";
	public static final String LeaseNext="//*[@id=\"gotoChannelOpt\"]";

	//CCCheck
	public static final String SalutationActual="//*[@id=\"form-account-info\"]/fieldset[2]/div/div[1]/div[1]/ul";
	public static final String Salutation="//*[@id=\"form-account-info\"]/fieldset[2]/div/div[1]/div[1]/ul/li/ul/li[{count}]/a";

	public static final String FirstName="//*[@id=\"fname\"]";
	public static final String LastName="//*[@id=\"lname\"]";
	public static final String Phone="//*[@id=\"phone\"]";
	public static final String Month="//*[@id=\"dobMonth\"]";
	public static final String Day="//*[@id=\"dobDay\"]";
	public static final String Year="//*[@id=\"dobYear\"]";
	public static final String Email="//*[@id=\"email\"]";
	public static final String Ssn1="//*[@id=\"password_ssn1\"]";
	public static final String Ssn2="//*[@id=\"password_ssn2\"]";
	public static final String Ssn3="//*[@id=\"password_ssn3\"]";
	public static final String Email1="//*[@id=\"siteMailId\"]";
	public static final String ChkEmail="//*[@id=\"checkUserEmailAvailability\"]";
	public static final String Pwd1="//*[@id=\"password\"]";
	public static final String Pwd2="//*[@id=\"confirmPassword\"]";
	public static final String RecoveryQuestion="//*[@id=\"verify_Select\"]/ul/li/a/span";
	
	public static final String Ques = "//*[@id=\"verify_Select\"]/ul/li/ul/li[2]/a";
	public static final String Drink="//*[@id=\"verify_Select\"]/ul/li/ul/li[2]/a";
	public static final String RecoveryAnswer="//*[@id=\"answer_secret_question\"]";
	public static final String ContinueSecurely="//*[@id=\"cartNextButton\"]/input";
	public static final String EmailSuccess="//*[@id=\"approvedUserId\"]/p";
	
	//*[@id="verify_Select"]/ul/li/ul/li[2]/a

	//*[@id="answer_secret_question"]

	//Install
	
	public static final String Pro = "//*[@id=\"install-delivery-type\"]/div[1]/div[2]/span[1]" ;
	public static final String Self = "//*[@id=\"install-delivery-type\"]/div[2]/div[2]/span[1]" ;
	public static final String Calender="//*[@id=\"install-header\"]/h3";
	public static final String InstallSel="//*[@id=\"nav-steps\"]/div/input";
	public static final String DateCell="//*[@id=\"install-month-table\"]/tbody/tr[{row}]/td[{col}]";
	public static final String DateRad="//*[@id=\"install-month-table\"]/tbody/tr[{row}]/td[{col}]/label/span";
	public static final String Date="//*[@id=\"install-month-table\"]/tbody/tr[2]/td[3]/label/span";
	public static final String Cell="//*[@id=\"install-month-table\"]/tbody/tr[0]/td[0]";
	public static final String Cell1="//*[@id=\"install-month-table\"]/tbody/tr[2]/td[3]";
	
	//Payment

	public static final String PaymentInformation="//*[@id=\"form-credit-check\"]/h2";
	public static final String SetupPayment="//*[@id=\"autoPayment\"]/span";
	public static final String CardNumber="//*[@id=\"card-number\"]";
	public static final String ExpMonth="//*[@id=\"exp-date-mm\"]";
	public static final String ExpYear="//*[@id=\"exp-date-yy\"]";
	public static final String Cvv="//*[@id=\"ccv\"]";
	public static final String CardFirst="//*[@id=\"fname_d\"]";
	public static final String CardLast="//*[@id=\"lname_d\"]";
	public static final String PaymentNext="//*[@id=\"gotoReview\"]";


	//SubmitPage
	public static final String RecPayment="//*[@id=\"checkout-order-review\"]/div[3]/span[1]";
	public static final String Ecobil="//*[@id=\"checkout-order-review\"]/div[3]/span[2]";
	public static final String SubmitOrder = "//*[@id=\"launch\"]";

	//Email Configurations
	
	public static String server="smtp.gmail.com";
	public static String from = "seleniumtester1977@gmail.com";
	public static String mypassword = "Windows@101";
	public static String[] to ={"seleniumtester1977@gmail.com","gdileep@xavient.com"};
	public static String subject = "Test Report of Order Lab_Regression";
	public static String messageBody ="Please see the attached Test Reports";
	public static String TestReportsPath=System.getProperty("user.dir")+"\\TestReports.zip";
	public static String TestReportsName="TestReports.zip";





}
