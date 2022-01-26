<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>

<style type="text/css">
   .green{
      color: green;
   
   }

</style>



</head>
<body>

<div>
   <input checked type="checkbox" value="el" id="el"><label for="el">초등학교</label><br>
   <input type="checkbox" value="mi" id="mi"><label for="mi">중학교</label><br>
   <input type="checkbox" value="hi" id="hi"><label for="hi">고등학교</label><br>
   
</div>


<script type="text/javascript">
   $(document).ready(function() {
      /* var arrCheckBox = $("[type='checkbox']");
      console.log("checkbox의 수: ", arrCheckBox.length);
      
      
      var arrCheckedCheckBox = $("[type='checkbox']:checked");
      console.log("checked된 checkbox의 수: ", arrCheckedCheckBox.length); */
      
      changBackgroundColor();
      
      
      
      $("[type='checkbox']").change(function() {
         changBackgroundColor();
         changeBackgroundColor_each();
      });
      
      
      function changeBackgroundColor_each() {
         $("[type='checkbox']").each(function() {
            if($(this).is(":checked")){
               $(this).next().addClass("green");
            }else{
               $(this).next().removeClass("green");
            }
            
            
         });
      }
      
      
      
      function changBackgroundColor() {
         var arrCheckBox = $("[type='checkbox']");
         for(var i=0;i<arrCheckBox.length; i++){
            /* $(arrCheckBox[i]).next().css("background-color", "red"); */
            
            if(arrCheckBox[i].checked){
               $(arrCheckBox[i]).next().css("background-color", "red");
            }else{
               $(arrCheckBox[i]).next().css("background-color", "yellow");
            }
         }
      }
   });
</script>



</body>
</html>
