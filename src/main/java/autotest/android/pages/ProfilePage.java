package autotest.android.pages;

import core.appium.driver.AppiumExtDriver;
import core.appium.enums.MobilePlatform;
import core.appium.page.MobileBasePage;
import core.locator.ByLocator;
import core.logger.LevelLogger;
import org.openqa.selenium.By;

/**
 * Created by zaborovsky on 21.12.2016.
 */
public class ProfilePage extends MobileBasePage {
    public ProfilePage() {
        super(MobilePlatform.ANDROID);
    }


//    Profile User Information

    private static final By USER_AVATAR = new ByLocator("//android.widget.ImageView[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/image_avatar']", true);
    private static final By USER_NAME = new ByLocator("//android.widget.TextView[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/text_full_name']", true);
    private static final By USER_STATUS = new ByLocator("//android.widget.TextView[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/label_star']", true);
    private static final By USER_DESCRIPTION = new ByLocator("//android.widget.TextView[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/text_description']", true);

    private static final By EDIT_PROFILE = new ByLocator("//android.widget.Button[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/button_edit_profile']", true);

    private static final By FOLLOWINGS = new ByLocator("//android.widget.TextView[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/following_counter']", true);
    private static final By FOLLOWERS = new ByLocator("//android.widget.TextView[@resource-id=" +
            "'ccom.mgrmobi.kitwts.uat:id/followers_counter'] and [@text='%s']", true);
    private static final By POSTS = new ByLocator("//android.widget.TextView[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/posts_counter']", true);

//   Profile navigation menu
    private static final By GALLERY_POSTS = new ByLocator("//android.widget.Button[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/button_gallery']", true);
    private static final By LIST_POSTS = new ByLocator("//android.widget.Button[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/button_list']", true);
    private static final By PURCHASES_POSTS = new ByLocator("//android.widget.Button[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/button_purchases']", true);
    private static final By MARKED_POSTS = new ByLocator("//android.view.Button[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/button_marked_posts']", true);


    private static final By EVENT_NAME = new ByLocator("//android.widget.TextView[@resource-id=" +
            "'com.mgrmobi.intouch:id/text_event_name']", true);
    private static final By BUTTON_GOING = new ByLocator("//android.widget.Button[@resource-id=" +
            "'com.mgrmobi.intouch:id/button_going']", true);

    private static final By GOING_EVENTS = new ByLocator("//android.widget.TextView[@text=" +
            "'Иду']", true);
    private static final By FAVORITE_EVENTS = new ByLocator("//android.widget.TextView[@text=" +
            "'Избранные']", true);

    private static final By PRE_LOADER = new ByLocator("//android.widget.ImageView[@resource-id=" +
            "'com.mgrmobi.intouch:id/progress_view']", true);

    private static final String OPEN_EVENT = "//android.support.v7.widget.RecyclerView[@resource-id='com.mgrmobi.intouch:id/id_recycler_view']/" +
            "android.view.View[@index='%d']";
    private static final By MENU_BUTTON = new ByLocator("//android.widget.ImageButton[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/menu_button']", true);
    private static final By OPEN_SETTINGS = new ByLocator("//android.widget.TextView[@text=" +
            "'Settings']", true);


    private static final By LOGOUT = new ByLocator("//android.widget.TextView[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/button_logout']", true);
    private static final By ACCEPT_LOGOUT = new ByLocator("//android.widget.Button[@resource-id=" +
            "'android:id/button1']", true);


    public boolean isAvatarPresent() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Проверяем есть ли логотип, элемент c xpath: '%s'",
                USER_AVATAR));
        boolean result = ((AppiumExtDriver)getSearchContext()).isPresent(USER_AVATAR);
        if(result) {
            result =  getSearchContext().findElement(USER_AVATAR).isDisplayed();
        }
        logger.log(LevelLogger.SCREEN_INFO, String.format("Результат => %s", result));
        return result;
    }

    public String userName() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Получаем имя пользователя, xpath '%s'.",
                USER_NAME.toString()));
        String result = getSearchContext().findElement(USER_NAME).getText();
        logger.log(LevelLogger.SCREEN_INFO, String.format("Результат => %s", result));
        return result;
    }

    public String userStatus() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Получаем статус пользователя, xpath '%s'.",
                USER_STATUS.toString()));
        String result = getSearchContext().findElement(USER_STATUS).getText();
        logger.log(LevelLogger.SCREEN_INFO, String.format("Результат => %s", result));
        return result;
    }

    public String userDescription() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Получаем описание пользователя, xpath '%s'.",
                USER_DESCRIPTION.toString()));
        String result = getSearchContext().findElement(USER_DESCRIPTION).getText();
        logger.log(LevelLogger.SCREEN_INFO, String.format("Результат => %s", result));
        return result;
    }

    public EditProfilePage openEditProfile() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Открываем экран редактирования профиля, нажимаем на " +
                "элемент c xpath: '%s'", EDIT_PROFILE.toString()));
        getSearchContext().findElement(EDIT_PROFILE).click();
        return mobilePageFactory.createPage(EditProfilePage.class);
    }

    public FollowingsPage openFollowingPage() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Открываем раздел с подписками, нажимаем на " +
                "элемент c xpath: '%s'", FOLLOWINGS.toString()));
        getSearchContext().findElement(FOLLOWINGS).click();
        return mobilePageFactory.createPage(FollowingsPage.class);
    }

    public String followingCounter() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Получаем число подписок, xpath '%s'.",
                FOLLOWINGS.toString()));
        String result = getSearchContext().findElement(FOLLOWINGS).getText();
        logger.log(LevelLogger.SCREEN_INFO, String.format("Результат => %s", result));
        return result;
    }

    public FollowersPage openFollowersPage() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Открываем раздел с подписчиками, нажимаем на " +
                "элемент c xpath: '%s'", FOLLOWERS.toString()));
        getSearchContext().findElement(FOLLOWERS).click();
        return mobilePageFactory.createPage(FollowersPage.class);
    }

    public String followersCounter() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Получаем число подписчиков, xpath '%s'.",
                FOLLOWERS.toString()));
        String result = getSearchContext().findElement(FOLLOWERS).getText();
        logger.log(LevelLogger.SCREEN_INFO, String.format("Результат => %s", result));
        return result;
    }

    public ProfilePage openPosts() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Открываем раздел с постами, нажимаем на " +
                "элемент c xpath: '%s'", POSTS.toString()));
        getSearchContext().findElement(POSTS).click();
        return this;
    }

    public String postsCounter() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Получаем число постов, xpath '%s'.",
                POSTS.toString()));
        String result = getSearchContext().findElement(POSTS).getText();
        logger.log(LevelLogger.SCREEN_INFO, String.format("Результат => %s", result));
        return result;
    }

    public UserPage openSettings() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Открываем экран настроек, нажимаем на " +
                "элемент c xpath: '%s'", MENU_BUTTON.toString()));
        getSearchContext().findElement(MENU_BUTTON).click();
        getSearchContext().findElement(OPEN_SETTINGS).click();
        return mobilePageFactory.createPage(UserPage.class);
    }

    public LogIn performLogout() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Выполняем логаут, нажимаем на " +
                "элемент c xpath: '%s'", MENU_BUTTON.toString()));
        getSearchContext().findElement(LOGOUT).click();
        getSearchContext().findElement(ACCEPT_LOGOUT).click();
        return mobilePageFactory.createPage(LogIn.class);
    }


//    public int numberOfHostEvent() {
//        logger.log(LevelLogger.SCREEN_ACTION, String.format("Проверяем есть ли логотип, элемент c xpath: '%s'",
//                USER_AVATAR));
//        boolean result = ((AppiumExtDriver)getSearchContext()).isPresent(USER_AVATAR);
//        if(result) {
//            result =  getSearchContext().findElement(USER_AVATAR).isDisplayed();
//        }
//        logger.log(LevelLogger.SCREEN_INFO, String.format("Результат => %s", result));
//        return result;
//    }

    public ProfilePage selectGallery() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Открываем посты галереей: '%s'", GALLERY_POSTS.toString()));
        getSearchContext().findElement(GALLERY_POSTS).click();
        return this;
    }

    public ProfilePage selectList() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Открываем посты списком: '%s'", LIST_POSTS.toString()));
        getSearchContext().findElement(LIST_POSTS).click();
        return this;
    }


    public ProfilePage selectPurchases() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Открываем раздел с купленными постами, xpath этого элемента: '%s'", PURCHASES_POSTS.toString()));
        getSearchContext().findElement(PURCHASES_POSTS).click();
        return this;
    }

    public ProfilePage selectMarkedPosts() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Открываем раздел с отметками в постах, xpath этого элемента: '%s'", MARKED_POSTS.toString()));
        getSearchContext().findElement(MARKED_POSTS).click();
        return this;
    }


    public FeedPage selectEvent(int number) {
        By locator = new ByLocator(String.format(OPEN_EVENT, number), true);
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Открываем событие под номером - '%d', xpath этого элемента: '%s'", number, locator.toString()));
        getSearchContext().findElement(locator).click();
        return mobilePageFactory.createPage(FeedPage.class);
    }

    public EditProfilePage editProfilePage() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Открываем редактирование профиля, нажимаем на " +
                "элемент c xpath: '%s'", EDIT_PROFILE.toString()));
        getSearchContext().findElement(EDIT_PROFILE).click();
        return mobilePageFactory.createPage(EditProfilePage.class);
    }

    public FeedPage selectEventByNumber(int number) {
        By locator = new ByLocator(String.format(OPEN_EVENT, number), true);
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Открываем событие под номером - '%d', xpath этого элемента: '%s'", number, locator.toString()));
        getSearchContext().findElement(locator).click();
        return mobilePageFactory.createPage(FeedPage.class);
    }

//    TODO: Сделать в профиле разные типы списков, сейчас все валится одной кучей, отличить не завершено и прошедшие невозможно

}