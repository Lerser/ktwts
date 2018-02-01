package autotest.android.pages;

import core.appium.driver.AppiumExtDriver;
import core.appium.enums.MobilePlatform;
import core.appium.page.MobileBasePage;
import core.locator.ByLocator;
import core.logger.LevelLogger;
import org.openqa.selenium.By;

/**
 * Created by zaborovsky on 09.01.2017.
 */
public class KitWTS extends MobileBasePage {


    private static final By BOTTOM_BAR = new ByLocator("//android.widget.LinearLayout[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/bb_bottom_bar_item_container']", true);

    private static final By TAB_FEED = new ByLocator("//android.widget.LinearLayout[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/tab_feed']", true);
    private static final By TAB_SEARCH = new ByLocator("//android.widget.LinearLayout[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/tab_search']", true);
    private static final By TAB_CREATE_POST = new ByLocator("//android.widget.LinearLayout[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/tab_create_post']", true);
    private static final By TAB_NOTIFICATIONS = new ByLocator("//android.widget.LinearLayout[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/tab_notifications']", true);
    private static final By TAB_PROFILE = new ByLocator("//android.widget.LinearLayout[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/tab_profile']", true);

    public KitWTS() {
        super(MobilePlatform.ANDROID);
    }

    public MainMenuList openMainMenu() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Открываем главное меню, нажимаем на " +
                "элемент c xpath: '%s'", BOTTOM_BAR.toString()));
        getSearchContext().findElement(BOTTOM_BAR).click();
//        Waiter.waitContext(getSearchContext(), MobileBasePage.LOAD_PAGE_SECONDS).withMessage(String.format("Меню " +
//                "не загрузилась в течении %d секунд.", MobileBasePage.LOAD_PAGE_SECONDS)).
//                until(SearchContextConditions.visibilityOfElementLocated(MENU_PRESENT));
        return mobilePageFactory.createPage(MainMenuList.class);
    }

    public boolean isBottomBarPresent() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Проверяем есть ли нижнее меню, элемент c xpath: '%s'",
                BOTTOM_BAR));
        boolean result = ((AppiumExtDriver)getSearchContext()).isPresent(BOTTOM_BAR);
        if(result) {
            result =  getSearchContext().findElement(BOTTOM_BAR).isDisplayed();
        }
        logger.log(LevelLogger.SCREEN_INFO, String.format("Результат => %s", result));
        return result;
    }

    public FeedPage openFeedPage() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Открываем ленту событий, нажимаем на " +
                "элемент c xpath: '%s'", TAB_FEED.toString()));
        getSearchContext().findElement(TAB_FEED).click();
        return mobilePageFactory.createPage(FeedPage.class);
    }

    public SearchPage openSearchPage() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Открываем раздел с поиском, нажимаем на " +
                "элемент c xpath: '%s'", TAB_SEARCH.toString()));
        getSearchContext().findElement(TAB_SEARCH).click();
        return mobilePageFactory.createPage(SearchPage.class);
    }

    public CreatePostPage openCreatePostPage() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Открываем раздел создания поста, нажимаем на " +
                "элемент c xpath: '%s'", TAB_CREATE_POST.toString()));
        getSearchContext().findElement(TAB_CREATE_POST).click();
        return mobilePageFactory.createPage(CreatePostPage.class);
    }

    public ProfilePage openProfilePage() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Открываем раздел с профилем, нажимаем на " +
                "элемент c xpath: '%s'", TAB_PROFILE.toString()));
        getSearchContext().findElement(TAB_PROFILE).click();
        return mobilePageFactory.createPage(ProfilePage.class);
    }





}


