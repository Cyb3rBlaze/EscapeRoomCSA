package com.cyber.GameUtils;

public class TriviaQuestion{
    private String[] questionList = new String[]{
            "How do you print to the console in Python?",
            "What is NOT a valid way to add 1 to a variable in Python?",
            "What is NOT a valid datatype in Python?",
            "What is the proper way to define a function in Python?",
            "What is 100%22%9?",
            "What is the proper way of doing a multi-line comment/string in Python?",
            "Which one of these is NOT a valid list method in Python?",
            "Which one of these is best to use when simulating prices at a grocery store?"
    };
    private String[][] answerList = new String[][]{
            {"print Hello", "printf(\"Hello\")", "print(\"Hello\")", "p(Hello)"},
            {"x += 1", "x = x+1", "x++", "x -= -1"},
            {"Integer", "Boolean", "String", "Double"},
            {"func funcname(a,b){}", "function funcname(a,b){}", "def funcname(a,b):", "define funcname(a,b):"},
            {"1", "3", "5", "7"},
            {"'''Comment Here'''", "/*Comment Here*/", "#Comment Here", "//Comment Here"},
            {".append()", ".push()", ".remove()", ".pop()"},
            {"dictionary", "tuple", "list", "set"}
    };
    private String[] correctAnswerList = new String[]{
            "print(\"Hello\")",
            "x++",
            "Double",
            "def funcname(a,b):",
            "1",
            "'''Comment Here'''",
            ".push()",
            "dictionary"
    };
    private String[] referenceList = new String[]{
            "https://youtu.be/fXz0ksSH6iE",
            "https://youtu.be/fXz0ksSH6iE",
            "https://youtu.be/fXz0ksSH6iE",
            "https://youtu.be/s1hf8mtK7BQ",
            "https://youtu.be/s1hf8mtK7BQ",
            "https://youtu.be/oPiF7LhURe8",
            "https://youtu.be/H2IPIrxzyJQ",
            "https://youtu.be/Vbj-n_wenlY"
    };
    private int nQuestions;
    public String question; public String[] answers; public String correctAnswer; public String reference;

    public TriviaQuestion(){
        this.nQuestions = questionList.length;
        int randomN = (int)(Math.random() * nQuestions - 0.5);
        this.question = questionList[randomN];
        this.answers = answerList[randomN];
        this.correctAnswer = correctAnswerList[randomN];
        this.reference = referenceList[randomN];
    }


}
