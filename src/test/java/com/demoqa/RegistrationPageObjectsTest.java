package com.demoqa;

import Page.RegistrationPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPageObjectsTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationFormTest() {

        registrationPage.openPage()
                .setFirstName("Anton")
                .setLastName("Beloved")
                .setEmail("Beglov@mail.ru")
                .setGender("Other")
                .setUserNumber("1234567890")
                .setDateOfBirth("20", "January", "1990");

        $("#subjectsInput").setValue("Biology").pressEnter();
        $("#subjectsInput").setValue("Chemistry").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("Medved_mzoo.jpg");
        $("#currentAddress").setValue("Sanctum Eternal");
        $("#stateCity-wrapper").$("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#stateCity-wrapper").$("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-content").should(appear);
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive").shouldHave(text("Anton Beloved"));
        $(".table-responsive").shouldHave(text("Beglov@mail.ru"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("1234567890"));
        $(".table-responsive").shouldHave(text("20 January,1990"));
        $(".table-responsive").shouldHave(text("Biology, Chemistry"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("Medved_mzoo.jpg"));
        $(".table-responsive").shouldHave(text("Sanctum Eternal"));
        $(".table-responsive").shouldHave(text("NCR Delhi"));
    }

}