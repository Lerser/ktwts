//package autotest.android.suites;
//
//import autotest.android.business_objects.UserData;
//import autotest.android.pages.*;
//import autotest.android.pages.page_enum.MainMenu;
//import autotest.android.utils.Utils;
//import core.appium.driver.AppiumExtDriver;
//import core.logger.LevelLogger;
//import core.test_case.BaseTestCase;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;
///**
// * Created by zaborovsky on 23.01.2017.
// */
//public class TestProfile extends BaseTestCase {
//    SoftAssert softAssert = new SoftAssert();
//
//    @Test(invocationCount = 1)
//    public void checkProfile() throws InterruptedException {
//        logger.log(LevelLogger.SCREEN_ACTION, "Начало теста");
//        KitWTS kitWTS = mobilePageFactory.createPage(KitWTS.class);
//        MainMenuList mainMenuList = mobilePageFactory.createPage(MainMenuList.class);
//        if (!(kitWTS.isBottomBarPresent())){
//            IntroPage introPage = mobilePageFactory.createPage(IntroPage.class);
//            LogIn login = introPage.openLoginPage();
//            UserData test_adult = new UserData("dafuq@grr.la", "dafuqgrr");
//            login.setUserData(test_adult);
//            kitWTS = login.login();
//        }
//        kitWTS.openMainMenu();
//        while (!(kitWTS.isBottomBarPresent())){
//            kitWTS.openMainMenu();
//            Utils.sleep(2);
//            kitWTS.openMainMenu();
//        }
//        Utils.sleep(2);
//        ProfilePage profilePage = mainMenuList.selectMainMenu(MainMenu.Profile);
//        softAssert.assertTrue(profilePage.isAvatarPresent(), "No avatar");
//
//    }
//
//
//    @Test(invocationCount = 1)
//    public void editProfile() throws InterruptedException {
//        logger.log(LevelLogger.SCREEN_ACTION, "Начало теста");
//        KitWTS kitWTS = mobilePageFactory.createPage(KitWTS.class);
//        MainMenuList mainMenuList = mobilePageFactory.createPage(MainMenuList.class);
//        if (!(kitWTS.isBottomBarPresent())){
//            IntroPage introPage = mobilePageFactory.createPage(IntroPage.class);
//            LogIn login = introPage.openLoginPage();
//            UserData test_adult = new UserData("dafuq@grr.la", "dafuqgrr");
//            login.setUserData(test_adult);
//            kitWTS = login.login();
//        }
//        kitWTS.openMainMenu();
//        while (!(kitWTS.isBottomBarPresent())){
//            kitWTS.openMainMenu();
//            Utils.sleep(2);
//            kitWTS.openMainMenu();
//        }
//        Utils.sleep(2);
//        ProfilePage profilePage = mainMenuList.selectMainMenu(MainMenu.Profile);
//        EditProfilePage editProfilePage = profilePage.editProfilePage();
//        editProfilePage.uploadAvatar(3);
//
//
//
//    }
//
//    @Test(invocationCount = 1)
//    public void checkSubscribers() throws InterruptedException {
//        logger.log(LevelLogger.SCREEN_ACTION, "Начало теста");
//        KitWTS kitWTS = mobilePageFactory.createPage(KitWTS.class);
//        MainMenuList mainMenuList = mobilePageFactory.createPage(MainMenuList.class);
//        if (!(kitWTS.isBottomBarPresent())){
//            IntroPage introPage = mobilePageFactory.createPage(IntroPage.class);
//            LogIn login = introPage.openLoginPage();
//            UserData test_adult = new UserData("dafuq@grr.la", "dafuqgrr");
//            login.setUserData(test_adult);
//            kitWTS = login.login();
//        }
//        kitWTS.openMainMenu();
//        while (!(kitWTS.isBottomBarPresent())){
//            kitWTS.openMainMenu();
//            Utils.sleep(2);
//            kitWTS.openMainMenu();
//        }
//
//        ProfilePage profilePage = mainMenuList.selectMainMenu(MainMenu.Profile);
////        FeedPage eventPage = profilePage.selectEvent(0);
//        Utils.sleep(2);
////        FollowersPage followersPage = profilePage.openSubscribersPage();
////        followersPage.subscribeByNumber(1);
//
//    }
//
//    @Test(invocationCount = 1)
//    public void searchSubscriber() throws InterruptedException {
//        logger.log(LevelLogger.SCREEN_ACTION, "Начало теста");
//        KitWTS kitWTS = mobilePageFactory.createPage(KitWTS.class);
//        MainMenuList mainMenuList = mobilePageFactory.createPage(MainMenuList.class);
//        if (!(kitWTS.isBottomBarPresent())){
//            IntroPage introPage = mobilePageFactory.createPage(IntroPage.class);
//            LogIn login = introPage.openLoginPage();
//            UserData test_adult = new UserData("dafuq@grr.la", "dafuqgrr");
//            login.setUserData(test_adult);
//            kitWTS = login.login();
//        }
//        kitWTS.openMainMenu();
//        while (!(kitWTS.isBottomBarPresent())){
//            kitWTS.openMainMenu();
//            Utils.sleep(2);
//            kitWTS.openMainMenu();
//        }
//
//        ProfilePage profilePage = mainMenuList.selectMainMenu(MainMenu.Profile);
//        Utils.sleep(2);
////        FollowersPage followersPage = profilePage.openSubscribersPage();
////        String str = "BBTouch1";
////        followersPage.search(str);
////        String nick = followersPage.getSubscriberNickByNumber(0);
////        nick.indexOf("BB");
////        softAssert.assertEquals(nick, str, "Wrong user found");
//////        Utils.sleep(5);
//    }
//
//    @Test(invocationCount = 1)
//    public void enterIntoSubscriber() throws InterruptedException {
//        logger.log(LevelLogger.SCREEN_ACTION, "Начало теста");
//        KitWTS kitWTS = mobilePageFactory.createPage(KitWTS.class);
//        MainMenuList mainMenuList = mobilePageFactory.createPage(MainMenuList.class);
//        if (!(kitWTS.isBottomBarPresent())){
//            IntroPage introPage =   mobilePageFactory.createPage(IntroPage.class);
//            LogIn login = introPage.openLoginPage();
//            UserData test_adult = new UserData("dafuq@grr.la", "dafuqgrr");
//            login.setUserData(test_adult);
//            kitWTS = login.login();
//        }
//        kitWTS.openMainMenu();
//        while (!(kitWTS.isBottomBarPresent())){
//            kitWTS.openMainMenu();
//            Utils.sleep(2);
//            kitWTS.openMainMenu();
//        }
//        ProfilePage profilePage = mainMenuList.selectMainMenu(MainMenu.Profile);
//        Utils.sleep(2);
////        FollowersPage followersPage = profilePage.openFollowingsPage();
////        followersPage.openSubscriberByNumber(0);
//    }
//
//    @Test(invocationCount = 1)
//    public void subscribeFromProfile() throws InterruptedException {
//        logger.log(LevelLogger.SCREEN_ACTION, "Начало теста");
//        KitWTS kitWTS = mobilePageFactory.createPage(KitWTS.class);
//        MainMenuList mainMenuList = mobilePageFactory.createPage(MainMenuList.class);
//        if (!(kitWTS.isBottomBarPresent())){
//            IntroPage introPage = mobilePageFactory.createPage(IntroPage.class);
//            LogIn login = introPage.openLoginPage();
//            UserData test_adult = new UserData("dafuq@grr.la", "dafuqgrr");
//            login.setUserData(test_adult);
//            kitWTS = login.login();
//        }
//        kitWTS.openMainMenu();
//        while (!(kitWTS.isBottomBarPresent())){
//            kitWTS.openMainMenu();
//            Utils.sleep(2);
//            kitWTS.openMainMenu();
//        }
//        ProfilePage profilePage = mainMenuList.selectMainMenu(MainMenu.Profile);
//        Utils.sleep(2);
////        FeedPage eventPage = profilePage.selectEvent(0);
//        FollowersPage followersPage = profilePage.openFollowersPage();
//        UserPage userPage = followersPage.openSubscriberByNumber(1);
//        userPage.subscribe();
//    }
//
//    @Test(invocationCount = 1)
//    public void favoriteEvents() throws InterruptedException {
//        logger.log(LevelLogger.SCREEN_ACTION, "Начало теста");
//        KitWTS kitWTS = mobilePageFactory.createPage(KitWTS.class);
//        MainMenuList mainMenuList = mobilePageFactory.createPage(MainMenuList.class);
//        if (!(kitWTS.isBottomBarPresent())){
//            IntroPage introPage = mobilePageFactory.createPage(IntroPage.class);
//            LogIn login = introPage.openLoginPage();
//            UserData test_adult = new UserData("dafuq@grr.la", "dafuqgrr");
//            login.setUserData(test_adult);
//            kitWTS = login.login();
//        }
//        kitWTS.openMainMenu();
//        while (!(kitWTS.isBottomBarPresent())){
//            kitWTS.openMainMenu();
//            Utils.sleep(2);
//            kitWTS.openMainMenu();
//        }
//        ProfilePage profilePage = mainMenuList.selectMainMenu(MainMenu.Profile);
//        profilePage.selectPurchases().selectEventByNumber(0);
//    }
//
//    @AfterMethod
//    public void tearDown() throws Exception {
//        AppiumExtDriver.getCurrentDriver().closeApp();
//        AppiumExtDriver.stopDriver(AppiumExtDriver.getCurrentDriver());
//
//    }
//
//
//}
