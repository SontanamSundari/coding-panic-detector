package coding_platform.service;

import coding_platform.model.Problem;
import coding_platform.model.Submission;
import coding_platform.model.TestCase;
import coding_platform.repository.TestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class CodeExecutionService {

    @Autowired
    private TestCaseRepository testCaseRepository;



    public String runSubmission(Submission submission) {
            System.out.println("ENTERED CODEEXECUTION RUNSUBMISSION");
System.out.println("LANGUAGE = " + submission.getLanguage());
System.out.println("CODE = ");
System.out.println(submission.getCode());
        try {
            // 1️⃣ Fetch test cases for the problem
            List<TestCase> testCases = testCaseRepository.findByProblemId(submission.getProblem().getId());
            System.out.println(
        "TEST CASE COUNT = " + testCases.size());
        if(testCases.isEmpty()){
    return "No test cases found for this problem.";
}
            for (TestCase tc : testCases) {
                System.out.println("INSIDE LOOP");
                            System.out.println("TEST CASE FOUND");
            System.out.println(tc.getInput());
                String result;

                if (submission.getLanguage().equalsIgnoreCase("python")) {
                    result = runPythonCode(submission.getCode(), tc.getInput());
                } else if (submission.getLanguage().equalsIgnoreCase("java")) {
                    result = runJavaCode(submission.getCode(), tc.getInput());
                } else {
                    return "Language not supported";
                }

                // ADD THESE CHECKS

                if(result.startsWith("Compilation Error")){
                    return result;
                }

                if(result.startsWith("Runtime Error")){
                    return result;
                }

                if (!result.equals(tc.getExpectedOutput())) {
                    return "Wrong Answer on input:\n"
                            + tc.getInput()
                            + "\nYour Output:\n"
                            + result;
                }
            }
            return "Accepted";
        } catch (Exception e) {
            return "Runtime Error: " + e.getMessage();
        }
    }

    // Python execution
    public String runPythonCode(String code, String input) throws IOException, InterruptedException {
        File tempFile = File.createTempFile("submission", ".py");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            writer.write(code);
        }

        ProcessBuilder pb = new ProcessBuilder("python", tempFile.getAbsolutePath());
        Process process = pb.start();

        try (BufferedWriter processInput = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()))) {
            processInput.write(input);
            processInput.flush();
        }

        BufferedReader outputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder output = new StringBuilder();
        String line;
        while ((line = outputReader.readLine()) != null) {
            output.append(line).append("\n");
        }

        BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        StringBuilder errors = new StringBuilder();
        while ((line = errorReader.readLine()) != null) {
            errors.append(line).append("\n");
        }

        process.waitFor(5, TimeUnit.SECONDS);
        tempFile.delete();

        if (errors.length() > 0) return "Runtime Error:\n" + errors.toString();

        return output.toString().trim();
    }

    // Java execution
    public String runJavaCode(String code, String input) throws IOException, InterruptedException {
        // 1. Write code to a .java file
        String uniqueId = String.valueOf(System.nanoTime());

File tempDir = new File("temp_" + uniqueId);
tempDir.mkdirs();

File tempFile = new File(tempDir, "Main.java");

        System.out.println("CODE RECEIVED:");
        System.out.println(code);

        try (FileWriter writer = new FileWriter(tempFile,false)) {
            writer.write(code);
            writer.flush();
        }
        System.out.println("FILE PATH: " + tempFile.getAbsolutePath());
        System.out.println("FILE EXISTS: " + tempFile.exists());
        System.out.println("FILE SIZE: " + tempFile.length());
        // 2. Compile
        Process compile = new ProcessBuilder(
        "javac",
        "Main.java"
        )
        .directory(tempDir)
        .start();
        int compileExit = compile.waitFor();

        System.out.println("COMPILE EXIT = " + compileExit);
        
        
        compile.waitFor(5, TimeUnit.SECONDS);

        BufferedReader compileError = new BufferedReader(new InputStreamReader(compile.getErrorStream()));
        StringBuilder errors = new StringBuilder();
        String line;
        while ((line = compileError.readLine()) != null) {
            errors.append(line).append("\n");
        }

        if (errors.length() > 0) {

            System.out.println("COMPILATION ERROR:");
            System.out.println(errors.toString());

            tempFile.delete();

            return "Compilation Error:\n" + errors.toString();
        }

        File classFile = new File(tempDir, "Main.class");

System.out.println("CLASS EXISTS = " + classFile.exists());
System.out.println("CLASS SIZE = " + classFile.length());

        // 3. Run
Process run = new ProcessBuilder(
        "java",
        "-cp",
        tempDir.getAbsolutePath(),
        "Main"
).start();

        try (BufferedWriter processInput = new BufferedWriter(new OutputStreamWriter(run.getOutputStream()))) {
            System.out.println("INPUT SENT:");
            System.out.println(input);
            processInput.write(input);
            processInput.flush();
        }

        BufferedReader outputReader = new BufferedReader(new InputStreamReader(run.getInputStream()));
        StringBuilder output = new StringBuilder();
        while ((line = outputReader.readLine()) != null) {
            output.append(line).append("\n");
        }

        BufferedReader errorReader = new BufferedReader(new InputStreamReader(run.getErrorStream()));
        errors = new StringBuilder();
        while ((line = errorReader.readLine()) != null) {
            errors.append(line).append("\n");
        }

        run.waitFor(5, TimeUnit.SECONDS);

        tempFile.delete();  // delete .java file
        new File(tempDir, "Main.class").delete(); // delete compiled class
        tempFile.delete();
tempDir.delete();

        if (errors.length() > 0) return "Runtime Error:\n" + errors.toString();

        System.out.println("CODE RECEIVED:");
        System.out.println(code);

        return output.toString().trim();

    }
    public String runCodeWithInput(String code,String lang,String input){
        try{
            if(lang.equalsIgnoreCase("Java")){
                return runJavaCode(code,input);
            }
            if(lang.equalsIgnoreCase("python")){
                return runPythonCode(code, input);
            }
            return "Language Not Supported";
        }
        catch(Exception e){
            return "Runtime Eror:"+e.getMessage();
        }
    }
}