<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
 <html lang="ja">
 <head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
 <link rel="stylesheet" href="css/style.css">
 <title>PlantsDetail</title>
 </head>
 <body>
 
 <feader>
   
 </feader>
 
 	<div class="row">
			<%-- 植物リストの繰り返し表示 --%>
			<c:forEach var="plant" items="${plants}">
				
					
							
							
								<a href="" class="card-title">${plant.plantName}</a>
								<p class="card-description" style=font-size:13px>
									和名: ${plant.japaneseName}<br> 学名: <em>${plant.scientificName}</em><br>
									属名: ${plant.genusName}<br>特徴: ${plant.description}
								</p>
								 
							
						
					</div>
					<!-- wrapper 終了 -->

				
			</c:forEach>
		</div>
		<!-- row 終了 -->
	</div>
	<!-- container 終了 -->
 
	<script src="js/jquery-2.1.4.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
 </body>
 </html>