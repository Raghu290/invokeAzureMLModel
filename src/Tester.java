public class Tester {

    public static void main(String... args) throws Exception {




        String key ="vSV4iSudupVWGcmv4PU82iUm7PTJCuAUhakMDPIx2Tl9UgJVGMMMQamWb6cIXI/oILG1rlLb7CoZJPSKpCpDXA==";
        String url ="https://ussouthcentral.services.azureml.net/workspaces/a3fcd41ba3cd468ebb57305e065e4a23/services/e30a5903fdd44733b2789dcb5545bbf8/execute?api-version=2.0&format=swagger";
        String requestBody = "{Inputs:{\"input1\":[{\"cyl\":\"1\",\"disp\":\"1\",\"hp\":\"1\",\"wt\":\"1\"}]},\"GlobalParameters\":{}}";

       // String requestBody = "\"Inputs\":{\"input1\":{\"ColumnNames\":[\"X\",\"Y\",\"Z\"],\"Values\":[[1,2,3],[1,2,3]]}},\"GlobalParameters\":{}}";
JavaAzureMLClient javaAzureMLClient = new JavaAzureMLClient(url,key);

        System.out.print(javaAzureMLClient.requestResponse(requestBody));
    }
}
