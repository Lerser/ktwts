package autotest.android.pages;

import core.appium.driver.AppiumExtDriver;
import core.appium.enums.MobilePlatform;
import core.appium.page.MobileBasePage;
import core.locator.ByLocator;
import core.logger.LevelLogger;
import org.openqa.selenium.By;

/**
 * Created by zaborovsky on 25.11.2017.
 */
public class FeedPage extends MobileBasePage {

    private static final By OPEN_MORE_MENU = new ByLocator("//android.widget.ImageButton[@resource-id=" +
            "'com.mgrmobi.intouch:id/button_more']", true);
    private static final By EDIT_EVENT = new ByLocator("//android.widget.TextView[@text=" +
            "'Изменить']", true);
    private static final By SHARE_EVENT = new ByLocator("//android.widget.TextView[@text=" +
            "'Поделиться…']", true);
    private static final By ADD_TO_FAVORITE = new ByLocator("//android.widget.TextView[@text=" +
            "'Добавить в Избранное']", true);



    private static final By OPEN_FEED = new ByLocator("//android.widget.LinearLayout[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/tab_feed']", true);

    private static final By PREMIUM_POST = new ByLocator("//android.widget.TextView[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/label_premium']", true);

    private static final By OPEN_POST = new ByLocator("//android.widget.ImageView[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/image_content']", true);
    private static final By OPEN_POST_MENU = new ByLocator("//android.widget.ImageView[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/button_popup_menu']", true);
    private static final By EDIT_POST = new ByLocator("//android.widget.TextView[@text=" +
            "'Edit Post']", true);
    private static final By DELETE_POST = new ByLocator("//android.widget.TextView[@text=" +
            "'Delete Post']", true);
    private static final By APPROVE_DELETE_POST = new ByLocator("//android.widget.Button[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/button_delete']", true);

    private static final By POST_STATUS = new ByLocator("//android.widget.TextView[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/text_resource_status']", true);
    private static final By PREMIUM_POST_STATUS = new ByLocator("//android.widget.TextView[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/label_premium']", true);

    private static final By LIKE_POST = new ByLocator("//android.widget.ImageView[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/button_like']", true);
    private static final By COUNTER_LIKES = new ByLocator("//android.view.View[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/text_likes_count']", true);
    private static final By COMMENTS = new ByLocator("//android.widget.ImageView[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/button_comments']", true);
    private static final By COUNTER_COMMENTS = new ByLocator("//android.widget.TextView[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/text_comments_count']", true);
    private static final By TEXT_COMMENT = new ByLocator("//android.widget.TextView[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/text_comment']", true);

    private static final String ITEM_XPATH_PATTERN = "//android.widget.FrameLayout[android.widget.LinearLayout/" +
            "android.widget.LinearLayout/android.widget.TextView[@text='%s']]";


    public FeedPage() {
        super(MobilePlatform.ANDROID);
    }


    public KitWTS openKitWTS() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Возвращаемся на главную, нажимаем на " +
                "элемент c xpath: '%s'", OPEN_FEED.toString()));
        getSearchContext().findElement(OPEN_FEED).click();
        return mobilePageFactory.createPage(KitWTS.class);
    }

    public FeedPage scrollToLikes() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Отматываем пост чтобы было видно лайки и комментарии, " +
                "элемент c xpath: '%s'", LIKE_POST.toString()));
        getSearchContext().findElement(LIKE_POST).click();
        ((AppiumExtDriver) getSearchContext()).swipe(450, 900, 450, 250,1300);
        return this;

    }

    public FeedPage likePost() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Лайкаем пост, нажимаем на " +
                "элемент c xpath: '%s'", LIKE_POST.toString()));
        getSearchContext().findElement(LIKE_POST).click();
        return this;
    }

    public String counterLikes() {
//        logger.log(LevelLogger.SCREEN_ACTION, String.format("Получаем число лайков, xpath '%s'.",
//                COUNTER_LIKES.toString()));
        String result = getSearchContext().findElement(COUNTER_LIKES).getAttribute("name");
        logger.log(LevelLogger.SCREEN_INFO, String.format("Число лайков => %s", result));
        return result;
    }

    public CommentPage commentPost() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Переходим в комментарии, нажимаем на " +
                "элемент c xpath: '%s'", COMMENTS.toString()));
        getSearchContext().findElement(COMMENTS).click();
        return mobilePageFactory.createPage(CommentPage.class);
    }

    public String counterComments() {
//        logger.log(LevelLogger.SCREEN_ACTION, String.format("Получаем число лайков, xpath '%s'.",
//                COUNTER_LIKES.toString()));
        String result = getSearchContext().findElement(COUNTER_COMMENTS).getAttribute("text");
        logger.log(LevelLogger.SCREEN_INFO, String.format("Число комментариев => %s", result));
        return result;
    }

    public String getTextComment() {
//        logger.log(LevelLogger.SCREEN_ACTION, String.format("Получаем число лайков, xpath '%s'.",
//                COUNTER_LIKES.toString()));
        String result = getSearchContext().findElement(TEXT_COMMENT).getAttribute("text");
        logger.log(LevelLogger.SCREEN_INFO, String.format("Описание поста => %s", result));
        return result;
    }

    public PostPage openPostPage() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Открываем пост, нажимаем на " +
                "элемент c xpath: '%s'", OPEN_POST.toString()));
        getSearchContext().findElement(OPEN_POST).click();
        return mobilePageFactory.createPage(PostPage.class);
    }

    public String postStatus() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Проверяем загрузку созданного поста " +
                "элемент c xpath: '%s'", POST_STATUS.toString()));
        String result = getSearchContext().findElement(POST_STATUS).getAttribute("text");
        return result;
    }

    public String premiumPost() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Проверяем статус созданного поста " +
                "элемент c xpath: '%s'", PREMIUM_POST_STATUS.toString()));
        String result = getSearchContext().findElement(PREMIUM_POST_STATUS).getAttribute("text");
        return result;
    }

    public FeedPage openPostMenu() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Открываем меню поста, нажимаем на " +
                "элемент c xpath: '%s'", OPEN_POST_MENU.toString()));
        getSearchContext().findElement(OPEN_POST_MENU).click();
        return this;
    }


    public FeedPage deletePost() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Удаляем пост, нажимаем на " +
                "элемент c xpath: '%s'", DELETE_POST.toString()));
        getSearchContext().findElement(DELETE_POST).click();
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Подтверждаем удаление, нажимаем на " +
                "элемент c xpath: '%s'", APPROVE_DELETE_POST.toString()));
        getSearchContext().findElement(APPROVE_DELETE_POST).click();
        return this;
    }

    public CreatePostPage editPost() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Редактируем пост, нажимаем на " +
                "элемент c xpath: '%s'", EDIT_POST.toString()));
        getSearchContext().findElement(EDIT_POST).click();
        return mobilePageFactory.createPage(CreatePostPage.class);
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
