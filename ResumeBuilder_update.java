import java.util.*;

public class ResumeBuilder_update
{
    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, String> userData = new LinkedHashMap<>(); 
    public static void main(String[] args) {
        System.out.println("Welcome to Online Resume Builder");

        gatherPersonalInfo();
        gatherEducationalBackground();
        gatherWorkExperience();
        gatherSkills();

        displayResume();

        scanner.close();
    }

    private static void gatherPersonalInfo() {
        System.out.println("\nPersonal Information:");
        userData.put("Full Name", getInput("Enter your full name: "));
        userData.put("Date of Birth", getInput("Enter your date of birth (YYYY-MM-DD): "));
        userData.put("Mother's Name", getInput("Enter your mother's name: "));
        userData.put("Father's Name", getInput("Enter your father's name: "));
        userData.put("Email", getInput("Enter your email address: "));
        userData.put("Phone Number", getInput("Enter your phone number: "));
        userData.put("Languages Known", getInput("Enter languages known (comma-separated): "));
    }

    private static void gatherEducationalBackground() {
        System.out.println("\nEducational Background:");
        userData.put("Degree", getInput("Enter your highest degree: "));
        userData.put("University", getInput("Enter your College Name: "));
        userData.put("CGPA", getInput("Enter your CGPA: "));
        userData.put("History of Arrears", getInput("Enter history of arrears: \n No History Of Arrers:(NHA) \n"+"           "+"or    \n No Standing Arrer(NSA): "));
        userData.put("Graduation Year", getInput("Enter your graduation year: "));
    }

    private static void gatherWorkExperience() {
        System.out.println("\nWork Experience (Leave input blank to finish):");
        List<String> workExperience = new ArrayList<>();
        String experience;

        do {
            experience = getInput("Enter job title and company: ");
            if (!experience.isEmpty()) {
                workExperience.add(experience);
            }
        } while (!experience.isEmpty());

        userData.put("Work Experience", String.join(", ", workExperience));
    }

    private static void gatherSkills() {
        System.out.println("\nSkills (Leave input blank to finish):");
        List<String> skills = new ArrayList<>();
        String skill;

        do {
            skill = getInput("Enter a skill: ");
            if (!skill.isEmpty()) {
                skills.add(skill);
            }
        } while (!skill.isEmpty());

        userData.put("Skills", String.join(", ", skills));
    }

    private static void displayResume() {
        System.out.println("\nGenerated CV/Resume:");
        System.out.println("-------------------------------------");

        userData.forEach((key, value) -> {
            if (key.equals("Full Name")) {
                System.out.println("Full Name: " + value);
            } else if (!key.equals("Full Name") && userData.containsKey("Full Name")) {
                System.out.println(key + ": " + value);
            }
        });

        userData.forEach((key, value) -> {
            if (key.equals("Degree")) {
                System.out.println("Degree: " + value);
            } else if (!key.equals("Degree") && userData.containsKey("Degree")) {
                System.out.println(key + ": " + value);
            }
        });

        userData.forEach((key, value) -> {
            if (key.equals("Work Experience")) {
                System.out.println("Work Experience: " + value);
            }
        });

        userData.forEach((key, value) -> {
            if (key.equals("Skills")) {
                System.out.println("Skills: " + value);
            }
        });

        System.out.println("-------------------------------------");
    }

    private static String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
