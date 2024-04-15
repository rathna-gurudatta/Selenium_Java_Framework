package listeners;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import utils.ExcelUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MethodInterceptor implements IMethodInterceptor {
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {

        List<Map<String, String>> list = ExcelUtils.getTestDetails();
        System.out.println("list " + list);
        List<IMethodInstance> result = new ArrayList<>();

        for(int i=0;i<methods.size();i++){
            for(int j=0;j<list.size();j++){
                if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("testname"))&&
                        list.get(j).get("execute").equalsIgnoreCase("yes")){
                    result.add(methods.get(i));
                }
            }
        }
        return result;
    }
}