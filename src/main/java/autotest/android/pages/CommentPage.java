package autotest.android.pages;

import core.appium.enums.MobilePlatform;
import core.appium.page.MobileBasePage;
import core.locator.ByLocator;
import core.logger.LevelLogger;
import org.openqa.selenium.By;

/**
 * Created by zaborovsky on 12.01.2017.
 */
public class CommentPage extends MobileBasePage {

    private static final By OPEN_MORE_MENU = new ByLocator("//android.widget.ImageButton[@resource-id=" +
            "'com.mgrmobi.intouch:id/button_more']", true);
    private static final By SHARE_EVENT = new ByLocator("//android.widget.TextView[@text=" +
            "'Поделиться…']", true);
    private static final By ADD_TO_FAVORITE = new ByLocator("//android.widget.TextView[@text=" +
            "'Добавить в Избранное']", true);

    private static final By BACK_BUTTON = new ByLocator("//android.widget.ImageView[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/button_back']", true);

    private static final By COMMENT_TEXT = new ByLocator("//android.widget.EditText[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/et_comment_text']", true);
    private static final By POST_COMMENT = new ByLocator("//android.widget.TextView[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/button_post_comment']", true);
    private static final By OPEN_FEED = new ByLocator("//android.widget.LinearLayout[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/tab_feed']", true);


    private static final By OPEN_POST = new ByLocator("//android.widget.ImageView[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/image_content']", true);
    private static final By OPEN_POST_MENU = new ByLocator("//android.widget.ImageView[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/button_popup_menu']", true);
    private static final By EDIT_POST = new ByLocator("//android.widget.TextView[@text=" +
            "'Добавить в Избранное']", true);
    private static final By DELETE_POST = new ByLocator("//android.widget.TextView[@text=" +
            "'Добавить в Избранное']", true);
    private static final By APPROVE_DELETE_POST = new ByLocator("//android.widget.Button[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/button_delete']", true);

    private static final String ITEM_XPATH_PATTERN = "//android.widget.FrameLayout[android.widget.LinearLayout/" +
            "android.widget.LinearLayout/android.widget.TextView[@text='%s']]";


    public CommentPage() {
        super(MobilePlatform.ANDROID);
    }


    public KitWTS openKitWTS() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Возвращаемся на главную, нажимаем на " +
                "элемент c xpath: '%s'", OPEN_FEED.toString()));
        getSearchContext().findElement(OPEN_FEED).click();
        return mobilePageFactory.createPage(KitWTS.class);
    }

    public FeedPage openFeedPage() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Возвращаемся к экрану с лентой, нажимаем на " +
                "элемент c xpath: '%s'", BACK_BUTTON.toString()));
        getSearchContext().findElement(BACK_BUTTON).click();
        return mobilePageFactory.createPage(FeedPage.class);
    }

    public PostPage openPostPage() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Возвращаемся к посту, нажимаем на " +
                "элемент c xpath: '%s'", BACK_BUTTON.toString()));
        getSearchContext().findElement(BACK_BUTTON).click();
        return mobilePageFactory.createPage(PostPage.class);
    }

    public CommentPage typeComment(String titleQuery) {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Вводим комментарий в элемент c xpath: '%s'", COMMENT_TEXT.toString()));
        getSearchContext().findElement(COMMENT_TEXT).click();
        getSearchContext().findElement(COMMENT_TEXT).sendKeys(titleQuery + "\\n");
        getSearchContext().findElement(POST_COMMENT).click();
        return this;
    }

    public CommentPage deletePost() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Открываем дополнительное меню для поста, нажимаем на " +
                "элемент c xpath: '%s'", BACK_BUTTON.toString()));
        getSearchContext().findElement(OPEN_POST_MENU).click();
        getSearchContext().findElement(DELETE_POST).click();
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Удаляем пост, нажимаем на " +
                "элемент c xpath: '%s'", APPROVE_DELETE_POST.toString()));
        getSearchContext().findElement(APPROVE_DELETE_POST).click();
        return this;
    }



    public <T extends MobileBasePage> T selectItem(String position, Class cl) {
        By locator = new ByLocator(String.format(ITEM_XPATH_PATTERN, position), true);
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Выбираем пункт - '%s',нажимаем на элемент c xpath: '%s'",
                position, locator.toString()));
        getSearchContext().findElement(locator).click();
        return (T)mobilePageFactory.createPage(cl);
    }


//    public String getEventStart() {
//        String eventName = getSearchContext().findElement(START_EVENT_DATE).getText();
//        logger.log(LevelLogger.SCREEN_ACTION, String.format("Получаем время начала события, элемент с xpath: '%s'", EVENT_NAME.toString()));
//        return eventName;
//    }
//
//    public FeedPage pressGoingButton() {
//        logger.log(LevelLogger.SCREEN_ACTION, String.format("На экране авторизации нажимаем на " +
//                "Войти, элемент c xpath: '%s'", BUTTON_GOING.toString()));
//        getSearchContext().findElement(BUTTON_GOING).click();
//        Waiter.waitContext(getSearchContext(), MobileBasePage.LOAD_PAGE_SECONDS).withMessage(String.format("Страница " +
//                "после авторизации страница не загрузилась в течении %d секунд.", MobileBasePage.LOAD_PAGE_SECONDS)).
//                until(SearchContextConditions.invisibilityOfElementLocated(PRE_LOADER));
//        return this;
//    }
//
//    public FeedPage addComment(String searchQuery) {
//        logger.log(LevelLogger.SCREEN_ACTION, String.format("Нажимаем в элемент c xpath: '%s', перехеодим на экран комментариев", ADD_COMMENT.toString()));
//        logger.log(LevelLogger.SCREEN_ACTION, String.format("Вводим поисковый запрос в элемент c xpath: '%s'", TYPE_COMMENT.toString()));
//        getSearchContext().findElement(ADD_COMMENT);
//        getSearchContext().findElement(COMMENT_AUTOCOMPLITE).sendKeys(searchQuery);
//        getSearchContext().findElement(SEND_COMMENT).click();
//        return this;
//    }
}
