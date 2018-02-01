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
//
///**
// * Created by zaborovsky on 31.01.2017.
// */
//public class TestEvents extends BaseTestCase {
//    SoftAssert softAssert = new SoftAssert();
//
//    @Test(invocationCount = 1)
//    public void createEvent() throws InterruptedException {
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
////        CreatePostPage createPostPage = mainMenuList.selectMainMenu(MainMenu.Create);
////        CreatePostPage image = createPostPage.addPhotoButton().addPhotoFromGallery();
////        image.selectPhotoFromGallery(0);
////        createPostPage.setTitle().typeTitle("KremlinTest");
////        createPostPage.applyButton().applyButton();
////
////        createPostPage.searchLocation("Kremlin").applyButton();
////        createPostPage.typeDescription("Kremlin Tests");
////        createPostPage.applyButton().applyButton();
////        createPostPage.setPrivate().applyButton().applyButton();
////        createPostPage.typeTicketLink("goo.gl").applyButton();
////        String st = createPostPage.getPublishText();
////        softAssert.assertEquals(st, "Опубликовать", "No avatar");
////        createPostPage.publishButton();
//
//    }
//
//    @Test(invocationCount = 0)
//    public void scrollTo() throws InterruptedException {
//        logger.log(LevelLogger.SCREEN_ACTION, "Начало теста");
//        KitWTS kitWTS = mobilePageFactory.createPage(KitWTS.class);
//
//        MainMenuList mainMenuList = kitWTS.openMainMenu();
//
//        Utils.sleep(1);
//
//        DiscoverPage discoverPage = mainMenuList.openDiscoverPage();
//        SearchPage searchPage = discoverPage.openSearchPage().search("3");
//        Utils.sleep(5);
//
//        FeedPage feedPage = searchPage.selectEventByNumber(1);
//
//
//
//        Utils.sleep(5);
//
//        logger.log(LevelLogger.SCREEN_ACTION, "Конец теста");
//    }
//
//    @Test(invocationCount = 1)
//    public void editEvent() throws InterruptedException {
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
//        Utils.sleep(1);
////        profilePage.openCreatedEventsPage();
//        FeedPage feedPage = profilePage.selectEventByNumber(0);
////        CreatePostPage editEvent = feedPage.openMoreMenu().openEditEventPage();
////        editEvent.setTitle().typeTitle("Moscow").applyButton();
////        editEvent.publishButton();
////        softAssert.assertEquals(feedPage.getEventName(), "MoscowKremlinTest","Event name mismatch");
////        logger.log(LevelLogger.SCREEN_ACTION, "Конец теста");
//    }
//
//    @Test(invocationCount = 1)
//    public void commentWithUser() throws InterruptedException {
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
//        Utils.sleep(1);
////        profilePage.openCreatedEventsPage();
//
//        FeedPage feedPage = profilePage.selectEventByNumber(0);
////        feedPage.scrollToPosition("Добавить комментарий");
////        feedPage.addComment("@dafuq go to");
////        Utils.sleep(2);
//
//
//        logger.log(LevelLogger.SCREEN_ACTION, "Конец теста");
//    }
//
//
//
//    @AfterMethod
//    public void tearDown() throws Exception {
//        AppiumExtDriver.stopDriver(AppiumExtDriver.getCurrentDriver());
////        AppiumExtDriver.getCurrentDriver().closeApp();
//
//    }
//}
