package autotest.android.pages;

import autotest.android.business_objects.UserData;
import core.appium.enums.MobilePlatform;
import core.appium.page.MobileBasePage;
import core.condition.SearchContextConditions;
import core.condition.Waiter;
import core.locator.ByLocator;
import core.logger.LevelLogger;
import org.openqa.selenium.By;

/**
 * Created by zaborovsky on 23.01.2017.
 */
public class EditProfilePage extends MobileBasePage {

    private static final By AVATAR_BACKGROUND = new ByLocator("//android.widget.EditText[@resource-id=" +
            "'com.mgrmobi.intouch:id/drawee_avatar_background']", true);
    private static final By AVATAR = new ByLocator("//android.widget.ImageView[@resource-id=" +
            "'com.mgrmobi.intouch:id/drawee_avatar']", true);

//    SonyXperiaC3

    private static final By AVATAR_GALLERY = new ByLocator("//android.widget.LinearLayout[@resource-id=" +
            "'com.mgrmobi.intouch:id/container_gallery']", true);
    private static final By AVATAR_PHOTO = new ByLocator("//android.widget.LinearLayout[@resource-id=" +
            "'com.mgrmobi.intouch:id/container_make_photo']", true);
    private static final By AVATAR_DELETE = new ByLocator("//android.widget.LinearLayout[@resource-id=" +
            "'com.mgrmobi.intouch:id/container_delete']", true);
    private static final String SELECT_IMAGE_BY_ID = "//android.support.v7.widget.RecyclerView[@resource-id='com.mgrmobi.intouch:id/id_recycler_view']/" +
            "android.widget.FrameLayout[@index='%d']";

    private static final By USERNAME = new ByLocator("//android.widget.EditText[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/et_nickname']", true);
    private static final By FIRSTNAME = new ByLocator("//android.widget.EditText[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/et_firstname']", true);
    private static final By LASTNAME = new ByLocator("//android.widget.EditText[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/et_lastname']", true);
    private static final By DESCRIPTION = new ByLocator("//android.widget.EditText[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/et_description']", true);

    private static final By DONE_BUTTON = new ByLocator("//android.widget.ImageButton[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/button_confirm']", true);
    private static final By PRE_LOADER = new ByLocator("//android.widget.ProgressBar[@resource-id=" +
            "'com.mgrmobi.kitwts.uat:id/progress_upload_content']", true);

//    Calendar

//


    public EditProfilePage() {
        super(MobilePlatform.ANDROID);
    }

    public EditProfilePage typeUsername(String username) {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Вводим username в элемент c xpath: '%s'", USERNAME.toString()));
        getSearchContext().findElement(USERNAME).sendKeys(username);
        return this;
    }

    public EditProfilePage typeFio(String firstname) {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Вводим firstname в элемент c xpath: '%s'", FIRSTNAME.toString()));
        getSearchContext().findElement(FIRSTNAME).sendKeys(firstname);
        return this;
    }

    public EditProfilePage typeLastname(String lastname) {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Вводим данные lastname в элемент c xpath: '%s'", LASTNAME.toString()));
        getSearchContext().findElement(LASTNAME).sendKeys(lastname + "\\n");
        return this;
    }

    public EditProfilePage typeDescription(String description) {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Вводим данные description в элемент c xpath: '%s'", DESCRIPTION.toString()));
        getSearchContext().findElement(DESCRIPTION).clear();
        getSearchContext().findElement(DESCRIPTION).sendKeys(description);

        return this;
    }

    public EditProfilePage uploadAvatar(int number) {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Открываем подменю для аватара, нажимаем на " +
                "элемент c xpath: '%s'", AVATAR.toString()));
        getSearchContext().findElement(AVATAR).click();
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Выбираем аватар из галереи, нажимаем на " +
                "элемент c xpath: '%s'", AVATAR_GALLERY.toString()));
        getSearchContext().findElement(AVATAR_GALLERY).click();
        By locator = new ByLocator(String.format(SELECT_IMAGE_BY_ID, number), true);
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Выбираем фотографию под номером - '%d', xpath этого элемента: '%s'", number, locator.toString()));
        getSearchContext().findElement(locator).click();
        return this;
    }

    public EditProfilePage deleteAvatar() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Открываем подменю для аватара, нажимаем на " +
                "элемент c xpath: '%s'", AVATAR.toString()));
        getSearchContext().findElement(AVATAR).click();
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Удаляем аватар, нажимаем на " +
                "элемент c xpath: '%s'", AVATAR_DELETE.toString()));
        getSearchContext().findElement(AVATAR_DELETE).click();
        return this;
    }

    public ProfilePage saveChanges() {
        logger.log(LevelLogger.SCREEN_ACTION, String.format("Сохраняем изменения в профиле, нажимаем на " +
                "элемент c xpath: '%s'", DONE_BUTTON.toString()));
        getSearchContext().findElement(DONE_BUTTON).click();
        Waiter.waitContext(getSearchContext(), MobileBasePage.LOAD_PAGE_SECONDS).withMessage(String.format("Лента " +
                "не загрузилась в течении %d секунд.", MobileBasePage.LOAD_PAGE_SECONDS)).
                until(SearchContextConditions.invisibilityOfElementLocated(PRE_LOADER));
        return mobilePageFactory.createPage(ProfilePage.class);
    }


    public EditProfilePage setUserData(UserData userData) {
        typeUsername(userData.getUsername());
        typeFio(userData.getEmail());
//        ty(userData.getPassword());
        return this;
    }

}
