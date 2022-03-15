package com.example.znolite;

import java.util.ArrayList;
import java.util.List;

public class QuestionsBank {

    public static List<QuestionsList> Family() {
        final List<QuestionsList> questionsLists = new ArrayList<>();

        final QuestionsList question1 = new QuestionsList("Family", "Семья", "Сын", "Жена", "Дочка", "Семья", "");
        final QuestionsList question2 = new QuestionsList("Job", "Профессия", "Работа", "Дача", "Стив Джобс", "Профессия", "");
        final QuestionsList question3 = new QuestionsList("Sun", "Солнце", "Небо", "Трава", "Дождь", "Солнце", "");

        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);

        return questionsLists;
    }

    public static List<QuestionsList> Work() {
        final List<QuestionsList> questionsLists = new ArrayList<>();

        final QuestionsList question1 = new QuestionsList("Police", "Профессия", "Полиция", "Пожарники", "Пол", "Полиция", "");
        final QuestionsList question2 = new QuestionsList("Student", "Директор", "Ученик", "Школа", "Не знаю", "Ученик", "");

        questionsLists.add(question1);
        questionsLists.add(question2);

        return questionsLists;
    }


    public static List<QuestionsList> getQuestions(String selectedTopicName) {
        switch (selectedTopicName) {
            case "Family":
                return Family();
            case "Work":
                return Work();
            default:
                return null;
        }
    }
}
