package com.demoqa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaTest extends TestBase {


    @Test
    void successfulRegistrationFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");


        $("#firstName").setValue("Anton");
        $("#lastName").setValue("Beloved");
        $("#userEmail").setValue("Beglov@mail.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__day--020:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("b").setValue("Biology").pressEnter();
        $("#subjectsInput").setValue("c").setValue("Chemistry").pressEnter();

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

        $(".table-responsive").shouldHave(text("Anton Beloved"),
                text("Beglov@mail.ru"), text("Male"), text("Male"),
                text("1234567890"), text("1234567890"), text("20 January,1990"),
                text("Biology, Chemistry"),
                text("Sports"), text("Medved_mzoo.jpg"),
                text("Sanctum Eternal"), text("NCR Delhi"));
    }

}
