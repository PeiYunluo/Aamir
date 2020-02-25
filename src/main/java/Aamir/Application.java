package Aamir;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/2/24 10:47
 */

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//test springboot
@RestController
public class Application extends Object {
    int a[] = {1, 2, 3, 4, 5};

    void out() {
        for (int j = 0; j < a.length; j++)
            System.out.println(a[j] + "");
    }

    public static void abc(String str) {
        str = "welcome";
    }

    @RequestMapping("/")
    @ResponseBody
    String helloAamir() {

      int arr[]={2,8,6,4};
      for (int i = 0;i<arr.length-1;i++){
          for (int j= 0;j<arr.length-1;j++){
              if (arr[j]>arr[j+1]){
                  int temp = arr[j+1];
                  arr[j+1]=arr[j];
                  arr[j]=temp;
              }
          }
      }
        for (int k =0;k<arr.length;k++)
            System.out.println(arr[k]);
        return "11";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
