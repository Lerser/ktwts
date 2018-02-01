package autotest.android.suites;

import autotest.android.pages.*;
import core.appium.driver.AppiumExtDriver;
import core.logger.LevelLogger;
import core.test_case.BaseTestCase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static core.asserts.Assert.assertEquals;
import static core.asserts.Assert.assertFalse;
import static core.asserts.Assert.assertTrue;

/**
 * Created by zaborovsky on 17.01.2017.
 */
public class TestAuthorization extends BaseTestCase {
    SoftAssert softAssert = new SoftAssert();


    @Test(invocationCount = 1)
    public void authStar() throws InterruptedException {
        logger.log(LevelLogger.SCREEN_ACTION, "Начало теста");
        KitWTS kitWTS = mobilePageFactory.createPage(KitWTS.class);
        if (kitWTS.isBottomBarPresent()){
            ProfilePage profilePage = kitWTS.openProfilePage();
            profilePage.openSettings().performLogout();

        }

        LogIn login =  mobilePageFactory.createPage(LogIn.class);
//        UserData test_adult = new UserData("joker", "qwerty");
//        login.setUserData(test_adult);
        login.typeUsername("joker");
        login.typePassword("qwerty");
        kitWTS = login.login();

        assertTrue(kitWTS.isBottomBarPresent(), "Не нашелся нижний блок меню");
    }

    @Test(invocationCount = 0)
    public void authFan() throws InterruptedException {
        logger.log(LevelLogger.SCREEN_ACTION, "Начало теста");
        KitWTS kitWTS = mobilePageFactory.createPage(KitWTS.class);
        if (kitWTS.isBottomBarPresent()){
            ProfilePage profilePage = kitWTS.openProfilePage();
            profilePage.openSettings().performLogout();

        }

        LogIn login =  mobilePageFactory.createPage(LogIn.class);
//        UserData test_adult = new UserData("marvin", "qwerty");
//        login.setUserData(test_adult);
        login.typeUsername("marvin");
        login.typePassword("qwerty");
        kitWTS = login.login();

        assertTrue(kitWTS.isBottomBarPresent(), "Не нашелся нижний блок меню");
    }

    @Test(invocationCount = 0)
    public void authFB() throws InterruptedException {
        logger.log(LevelLogger.SCREEN_ACTION, "Начало теста");
        KitWTS kitWTS = mobilePageFactory.createPage(KitWTS.class);


        IntroPage introPage = mobilePageFactory.createPage(IntroPage.class);
        LogIn login = introPage.openLoginPage();
        kitWTS = login.loginTwitter();

        logger.log(LevelLogger.SCREEN_ACTION, "Конец теста");
    }

    @Test(invocationCount = 1)
    public void checkPost() throws InterruptedException {
        logger.log(LevelLogger.SCREEN_ACTION, "Начало теста");
        KitWTS kitWTS = mobilePageFactory.createPage(KitWTS.class);
        if (!kitWTS.isBottomBarPresent()){
            LogIn login =  mobilePageFactory.createPage(LogIn.class);
            login.typeUsername("joker");
            login.typePassword("qwerty");
            kitWTS = login.login();
        }
        FeedPage feedPage = kitWTS.openFeedPage();
        PostPage postPage = feedPage.openPostPage();
        assertTrue(postPage.isImagePresent(), "Не нашлась картинка");
    }

    @Test(invocationCount = 1)
    public void checkLike() throws InterruptedException {
        logger.log(LevelLogger.SCREEN_ACTION, "Начало теста");
        KitWTS kitWTS = mobilePageFactory.createPage(KitWTS.class);
        if (!kitWTS.isBottomBarPresent()){
            LogIn login =  mobilePageFactory.createPage(LogIn.class);
            login.typeUsername("joker");
            login.typePassword("qwerty");
            kitWTS = login.login();
        }
        FeedPage feedPage = kitWTS.openFeedPage();

        feedPage.scrollToLikes();
        String likesBefore = feedPage.counterLikes();
        feedPage.likePost();
        String likesAfter = feedPage.counterLikes();
        Boolean b=(likesAfter==likesBefore);
        assertFalse(b, "Счетчик лайков не изменился");
        feedPage.likePost();
        likesBefore = feedPage.counterLikes();
        b=(likesAfter==likesBefore);
        assertFalse(b, "Счетчик лаcom.mgrmobi.kitwts.uat:id/label_premiumйков не изменился");

        PostPage postPage = feedPage.openPostPage();
        postPage.likePost();
        likesAfter = postPage.counterLikes();
        b=(likesAfter==likesBefore);
        assertFalse(b, "Счетчик лайков не изменился");
        postPage.likePost();
        likesBefore = postPage.counterLikes();
        b=(likesAfter==likesBefore);
        assertFalse(b, "Счетчик лайков не изменился");
        postPage.closePost();
    }

    @Test(invocationCount = 5)
    public void checkComment() throws InterruptedException {
        logger.log(LevelLogger.SCREEN_ACTION, "Начало теста");
        KitWTS kitWTS = mobilePageFactory.createPage(KitWTS.class);
        if (!kitWTS.isBottomBarPresent()){
            LogIn login =  mobilePageFactory.createPage(LogIn.class);
            login.typeUsername("joker");
            login.typePassword("qwerty");
            kitWTS = login.login();
        }
        FeedPage feedPage = kitWTS.openFeedPage();
        feedPage.scrollToLikes();
        feedPage.scrollToLikes();
        String commentsBefore = feedPage.counterComments();
        CommentPage commentPage = feedPage.commentPost();
        commentPage.typeComment("TestComment1");
        commentPage.openFeedPage();
        String commentsAfter = feedPage.counterComments();
        Boolean b=(commentsAfter==commentsBefore);
        assertFalse(b, "Счетчик комментариев не изменился!");
        PostPage postPage = feedPage.openPostPage();
        commentsAfter = postPage.counterComments();
        b=(commentsAfter==commentsBefore);
        assertFalse(b, "Счетчик комментариев не изменился!");
        commentPage = postPage.commentPost();
        commentPage.typeComment("TestComment2");
        commentPage.openPostPage();
        commentsBefore = feedPage.counterComments();
        b=(commentsAfter==commentsBefore);
        assertFalse(b, "Счетчик комментариев не изменился!");
        postPage.closePost();
        b=(commentsAfter==commentsBefore);
        assertFalse(b, "Счетчик комментариев не изменился!");
    }

    @Test(invocationCount = 5)
    public void checkCreateFreePost() throws InterruptedException {
        logger.log(LevelLogger.SCREEN_ACTION, "Начало теста");
        KitWTS kitWTS = mobilePageFactory.createPage(KitWTS.class);
        if (!kitWTS.isBottomBarPresent()){
            LogIn login =  mobilePageFactory.createPage(LogIn.class);
            login.typeUsername("joker");
            login.typePassword("qwerty");
            kitWTS = login.login();
        }
        CreatePostPage createPostPage = kitWTS.openCreatePostPage();
        createPostPage.openGallery();
        createPostPage.doneButton();
        createPostPage.markStar();
        createPostPage.markOnPhoto().searchStar("joker").selectStar("joker");
        createPostPage.doneButton();
        createPostPage.typeDescription("TestPost");
        FeedPage feedPage = createPostPage.createPost();
        assertTrue(kitWTS.isBottomBarPresent(), "Не нашелся нижний блок меню");
        assertEquals(feedPage.postStatus(), "Processing…", "Статус загрузки отработал не корректно");
    }

    @Test(invocationCount = 1)
    public void checkCreatePremiumPost() throws InterruptedException {
        logger.log(LevelLogger.SCREEN_ACTION, "Начало теста");
        KitWTS kitWTS = mobilePageFactory.createPage(KitWTS.class);
        if (!kitWTS.isBottomBarPresent()){
            LogIn login =  mobilePageFactory.createPage(LogIn.class);
            login.typeUsername("joker");
            login.typePassword("qwerty");
            kitWTS = login.login();
        }
        CreatePostPage createPostPage = kitWTS.openCreatePostPage();
        createPostPage.openGallery();
        createPostPage.doneButton();
        createPostPage.setPremium();
        createPostPage.savePrice("0");
        createPostPage.doneButton();
        FeedPage feedPage = createPostPage.createPost();
        assertTrue(kitWTS.isBottomBarPresent(), "Не нашелся нижний блок меню");
        assertEquals(feedPage.postStatus(), "Processing…", "Статус загрузки отработал не корректно");
        assertEquals(feedPage.premiumPost(), "Premium","Не нашелся нижний блок меню");
    }

    @Test(invocationCount = 1)
    public void editPost() throws InterruptedException {
        logger.log(LevelLogger.SCREEN_ACTION, "Начало теста");
        KitWTS kitWTS = mobilePageFactory.createPage(KitWTS.class);
        if (!kitWTS.isBottomBarPresent()){
            LogIn login =  mobilePageFactory.createPage(LogIn.class);
            login.typeUsername("joker");
            login.typePassword("qwerty");
            kitWTS = login.login();
        }
        String text = "TestPost";
        FeedPage feedPage = kitWTS.openFeedPage();

        CreatePostPage editPostPage = feedPage.openPostMenu().editPost();
        editPostPage.typeDescription(text);
        feedPage = editPostPage.createPost();
        feedPage.scrollToLikes();
        assertEquals(feedPage.getTextComment(), "joker " + text + " ", "Не совпали комментарии");
    }

    @Test(invocationCount = 1)
    public void deletePost() throws InterruptedException {
        logger.log(LevelLogger.SCREEN_ACTION, "Начало теста");
        KitWTS kitWTS = mobilePageFactory.createPage(KitWTS.class);
        if (!kitWTS.isBottomBarPresent()){
            LogIn login =  mobilePageFactory.createPage(LogIn.class);
            login.typeUsername("joker");
            login.typePassword("qwerty");
            kitWTS = login.login();
        }
        FeedPage feedPage = kitWTS.openFeedPage();
        feedPage.openPostMenu().deletePost();
    }

    @Test(invocationCount = 5)
    public void checkProfile() throws InterruptedException {
        logger.log(LevelLogger.SCREEN_ACTION, "Начало теста");
        KitWTS kitWTS = mobilePageFactory.createPage(KitWTS.class);
        if (!kitWTS.isBottomBarPresent()){
            LogIn login =  mobilePageFactory.createPage(LogIn.class);
            login.typeUsername("joker");
            login.typePassword("qwerty");
            kitWTS = login.login();
        }
        ProfilePage profilePage = kitWTS.openProfilePage();
        assertTrue(profilePage.isAvatarPresent(),"Аватар не найден");
        lightAssert.assertEquals(profilePage.userName(),"private joker", "Имя не совпало с ожидаемым");
    }

    @Test(invocationCount = 1)
    public void editProfile() throws InterruptedException {
        logger.log(LevelLogger.SCREEN_ACTION, "Начало теста");
        KitWTS kitWTS = mobilePageFactory.createPage(KitWTS.class);
        if (!kitWTS.isBottomBarPresent()){
            LogIn login =  mobilePageFactory.createPage(LogIn.class);
            login.typeUsername("joker");
            login.typePassword("qwerty");
            kitWTS = login.login();
        }
        String text = "TestPost";
        ProfilePage profilePage = kitWTS.openProfilePage();
        EditProfilePage editProfilePage = profilePage.editProfilePage();
        editProfilePage.typeDescription(text);
        editProfilePage.saveChanges();
        assertEquals(profilePage.userDescription(),text, "Описание не совпало с ожидаемым");
    }
    @AfterMethod
    public void tearDown() throws Exception {
        AppiumExtDriver.stopDriver(AppiumExtDriver.getCurrentDriver());
        //AppiumExtDriver.getCurrentDriver().closeApp();
    }
}
