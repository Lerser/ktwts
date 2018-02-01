package autotest.android.pages;

import core.appium.enums.MobilePlatform;
import core.appium.page.MobileBasePage;
import core.condition.SearchContextConditions;
import core.condition.Waiter;
import core.locator.ByLocator;
import core.logger.LevelLogger;
import org.openqa.selenium.By;

/**
 * Created by zaborovsky on 27.01.2017.
 */
public class CreatePostPage extends MobileBasePage {


    private static final By DONE_BUTTON = new ByLocator("//android.widget.ImageView[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/button_done']", true);
    private static final By PRE_LOADER = new ByLocator("//android.widget.ProgressBar[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/progress_upload_content']", true);
    private static final By UPDATE_LOADER = new ByLocator("//android.widget.ProgressBar[@resource-id=" +
            "'android:id/progress']", true);

    private static final By CAMERA_SHOT = new ByLocator("//android.widget.ImageView[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/button_take']", true);
    private static final By CAMERA_ACCEPT = new ByLocator("//android.widget.Button[@resource-id=" +
            "'com.mgrmobi.intouch:id/button_accept_photo']", true);
    private static final By SELECT_PREMIUM = new ByLocator("//android.widget.Switch[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/switch_premium']", true);
    private static final By EDIT_PRICE = new ByLocator("//android.widget.EditText[@resource-id=" +
            "'ccom.mgrmobi.kitwts.uat:id/et_price']", true);
    private static final By SAVE_PRICE = new ByLocator("//android.widget.Button[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/button_save']", true);

//    mark a star
    private static final By MARK_STAR = new ByLocator("//android.widget.TextView[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/button_mark_stars']", true);
    private static final By MARK_PHOTO = new ByLocator("//android.widget.ImageView[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/id_manage_post_photo_preview']", true);
    private static final By SEARCH_STAR = new ByLocator("//android.widget.EditText[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/et_search_field']", true);
    private static final By LOADING_STAR = new ByLocator("//android.widget.ProgressBar[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/pagination_progress_bar']", true);
    private static final By STAR_NICKNAME = new ByLocator("//android.widget.TextView[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/id_nickname']", true);
    private static final By MARK_COUNTER = new ByLocator("//android.widget.TextView[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/label_marks_counter']", true);


    private static final By FROM_GALLERY = new ByLocator("//android.widget.ImageView[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/image_photo_icon']", true);
    private static final String SELECT_IMAGE_BY_ID = "/android.widget.FrameLayout[@resource-id=" +
            "com.mgrmobi.kitwts.uat:id/checkable_background[@index='%d']";


    private static final By ADD_TITLE = new ByLocator("//android.widget.TextView[@text=" +
            "'Введи название']", true);

    private static final By TYPE_DESCRIPTION = new ByLocator("//android.widget.EditText[@package=" +
            "'com.mgrmobi.kitwts.uat']", true);

    private static final By FINISH_BUTTON = new ByLocator("//android.widget.ImageButton[@resource-id=" +
            "'com.mgrmobi.intouch:id/button_finish']", true);

    public CreatePostPage() {
        super(MobilePlatform.ANDROID);
    }



    public CreatePostPage openGallery() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Переходим в галерею xpath: '%s'", FROM_GALLERY.toString()));
        getSearchContext().findElement(FROM_GALLERY).click();
        return this;
    }

    public CreatePostPage makePhoto() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Делаем снимок, жмем в xpath: '%s'", CAMERA_SHOT.toString()));
        getSearchContext().findElement(CAMERA_SHOT).click();
        return this;
    }


    public CreatePostPage selectPhotoFromGallery(int number) {
        By locator = new ByLocator(String.format(SELECT_IMAGE_BY_ID, number), true);
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Выбираем фотографию под номером - '%d', xpath этого элемента: '%s'", number, locator.toString()));
        getSearchContext().findElement(locator).click();
        return this;
    }

    public CreatePostPage setPrice(String number) {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Вводим стоимость в элемент c xpath: '%s'", EDIT_PRICE.toString()));
        getSearchContext().findElement(EDIT_PRICE).click();
        getSearchContext().findElement(EDIT_PRICE).sendKeys(number);
        getSearchContext().findElement(SAVE_PRICE).click();
        return this;
    }

    public CreatePostPage markStar() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Переходим в режим отметки на фото, нажимаем на элемент c xpath: '%s'", MARK_STAR.toString()));
        getSearchContext().findElement(MARK_STAR).click();
        return this;
    }

    public CreatePostPage markOnPhoto() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Тапаем на фото, чтобы отметить звезду, нажимаем на элемент c xpath: '%s'", MARK_PHOTO.toString()));
        getSearchContext().findElement(MARK_PHOTO).click();
        return this;
    }

    public CreatePostPage searchStar(String searchQuery) {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Вводим поисковый запрос в элемент c xpath: '%s'", SEARCH_STAR.toString()));
        getSearchContext().findElement(SEARCH_STAR).click();
        getSearchContext().findElement(SEARCH_STAR).sendKeys(searchQuery + "\\n");
        Waiter.waitContext(getSearchContext(), MobileBasePage.LOAD_PAGE_SECONDS).withMessage(String.format("Список " +
                "звезд не загрузилась в течении %d секунд.", MobileBasePage.LOAD_PAGE_SECONDS)).
                until(SearchContextConditions.invisibilityOfElementLocated(LOADING_STAR));
        return this;
    }

    public CreatePostPage selectStar(String searchQuery) {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Выбираем звезду с ником в xpath: '%s'", SEARCH_STAR.toString()));
        String nickname = getSearchContext().findElement(STAR_NICKNAME).getAttribute("text");
        getSearchContext().findElement(STAR_NICKNAME).click();
        return this;
    }

    public String markCounter() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Получаем число отмеченных звезд, xpath '%s'.",
                MARK_COUNTER.toString()));
        String result = getSearchContext().findElement(MARK_COUNTER).getText();
        logger.log(LevelLogger.SCREEN_INFO, String.format("Результат => %s", result));
        return result;
    }

    public CreatePostPage setDescription() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Переходим на экран ввода названия события, нажимаем на элемент c xpath: '%s'", ADD_TITLE.toString()));
        getSearchContext().findElement(ADD_TITLE).click();
        return this;
    }

    public CreatePostPage doneButton() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Нажимаем кнопку Done, элемент c xpath: '%s'", DONE_BUTTON.toString()));
        getSearchContext().findElement(DONE_BUTTON).click();
        return this;
    }

    public FeedPage createPost() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Нажимаем кнопку Done, элемент c xpath: '%s'", DONE_BUTTON.toString()));
        getSearchContext().findElement(DONE_BUTTON).click();
        Waiter.waitContext(getSearchContext(), MobileBasePage.LOAD_PAGE_SECONDS).withMessage(String.format("Лента " +
                "не загрузилась в течении %d секунд.", MobileBasePage.LOAD_PAGE_SECONDS)).
                until(SearchContextConditions.invisibilityOfElementLocated(PRE_LOADER));
        return mobilePageFactory.createPage(FeedPage.class);
    }

    public FeedPage updatePost() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Нажимаем кнопку Done, элемент c xpath: '%s'", DONE_BUTTON.toString()));
        getSearchContext().findElement(DONE_BUTTON).click();
        Waiter.waitContext(getSearchContext(), MobileBasePage.LOAD_PAGE_SECONDS).withMessage(String.format("Лента " +
                "не загрузилась в течении %d секунд.", MobileBasePage.LOAD_PAGE_SECONDS)).
                until(SearchContextConditions.invisibilityOfElementLocated(UPDATE_LOADER));
        return mobilePageFactory.createPage(FeedPage.class);
    }

    public CreatePostPage setPremium() {
        String st = getSearchContext().findElement(SELECT_PREMIUM).getAttribute("checked");
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Платный пост: '%s'", st));
        if (Boolean.valueOf(getSearchContext().findElement(SELECT_PREMIUM).getAttribute("checked"))) {
            logger.log(LevelLogger.SCREEN_ACTION, String.format("Меняем пост на бесплатный, элемент c xpath: '%s'", SELECT_PREMIUM.toString()));
            getSearchContext().findElement(SELECT_PREMIUM).click();
        } else {
            logger.log(LevelLogger.SCREEN_ACTION, String.format("Меняем пост на платный, элемент c xpath: '%s'", SELECT_PREMIUM.toString()));
            getSearchContext().findElement(SELECT_PREMIUM).click();
        }
        return this;
    }

    public CreatePostPage savePrice(String price) {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Сохраняем стоимость, тапаем в элемент c xpath: '%s'", SAVE_PRICE.toString()));
//        getSearchContext().findElement(EDIT_PRICE).click();
//        getSearchContext().findElement(EDIT_PRICE).sendKeys(price +  "\\n");
        getSearchContext().findElement(SAVE_PRICE).click();
        return this;
    }

    public CreatePostPage typeDescription(String titleQuery) {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Вводим описание события в элемент c xpath: '%s'", TYPE_DESCRIPTION.toString()));
        getSearchContext().findElement(TYPE_DESCRIPTION).click();
        getSearchContext().findElement(TYPE_DESCRIPTION).clear();
        getSearchContext().findElement(TYPE_DESCRIPTION).sendKeys(titleQuery);
        return this;
    }




//    public CreatePostPage searchLocation(String searchQuery) {
//        logger.log(LevelLogger.SCREEN_ACTION, String.format("Вводим поисковый запрос в элемент c xpath: '%s'", SEARCH_LOCATION.toString()));
//        getSearchContext().findElement(SEARCH_LOCATION).click();
//        getSearchContext().findElement(SEARCH_LOCATION).sendKeys(searchQuery);
//     /* Далее идет махровый хардкод, сделано чтобы закостылить выбор из поиска т.к. гугловое апи было криво прокинруто
//     * */
//        Utils.sleep(2);
//
//        ((AppiumExtDriver) getSearchContext()).tap(1, 450, 275, 150);
//        return this;
//    }



//    public CreatePostPage setLocation() {
//
//        logger.log(LevelLogger.SCREEN_ACTION, String.format("Вводим поисковый запрос в элемент c xpath: '%s'", SEARCH_LOCATION.toString()));
//        getSearchContext().findElement(SEARCH_LOCATION).click();
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        int width = ((Long) js.executeScript("return window.innerWidth || document.body.clientWidth")).intValue() ;
//        LLLogs.getLogger().info("width value calculated is :" +width);
//        int height = ((Long) js.executeScript("return window.innerHeight || document.body.clientHeight")).intValue() ;
//        LLLogs.getLogger().info("height value calculated is :" +height);
//        Dimension dimension  = new Dimension(width, height);
//     /* Далее идет махровый хардкод, сделано чтобы закостылить выбор из поиска т.к. гугловое апи было криво прокинруто
//     * */
//
//        ((AppiumExtDriver) getSearchContext()).tap(1, 450, 275, 150);
//        return this;
//    }





//    public CreatePostPage typeTicketLink(String titleQuery) {
//        logger.log(LevelLogger.SCREEN_ACTION, String.format("Вводим поисковый запрос в элемент c xpath: '%s'", TYPE_LINK_FOR_TICKETS.toString()));
//        getSearchContext().findElement(TYPE_LINK_FOR_TICKETS).click();
//        getSearchContext().findElement(TYPE_LINK_FOR_TICKETS).sendKeys(titleQuery + "\\n");
//        return this;
//    }

//    public CreatePostPage publishButton() {
//        logger.log(LevelLogger.SCREEN_ACTION, String.format("Выбираем 'Опубликовать', элемент c xpath: '%s'", PUBLISH_BUTTON.toString()));
//        String result = getSearchContext().findElement(PUBLISH_BUTTON).getText();
//        logger.log(LevelLogger.SCREEN_INFO, String.format("Содержимое кнопки => %s", result));
//        getSearchContext().findElement(PUBLISH_BUTTON).click();
//        return this;
//    }
//
//    public String getPublishText() {
//        logger.log(LevelLogger.SCREEN_ACTION, String.format("Получаем текст кнопки с Опубликовать, ее xpath '%s'.",
//                PUBLISH_BUTTON.toString()));
//        String result = getSearchContext().findElement(PUBLISH_BUTTON).getText();
//        logger.log(LevelLogger.SCREEN_INFO, String.format("Результат => %s", result));
//        return result;
//    }
//
//    public CreatePostPage finishButton() {
//        logger.log(LevelLogger.SCREEN_ACTION, String.format("Выбираем 'Опубликовать', элемент c xpath: '%s'", FINISH_BUTTON.toString()));
//        getSearchContext().findElement(FINISH_BUTTON).click();
//        return this;
//    }
//
//    public UserPage openSubscribedByNumber() {
//        logger.log(LevelLogger.SCREEN_ACTION, String.format("Вводим поисковый запрос в элемент c xpath: '%s'", SET_PHOTO.toString()));
//        getSearchContext().findElement(SET_PHOTO).click();
//        return mobilePageFactory.createPage(UserPage.class);
//    }
}
