<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test = "${id_category==null}">
  <c:forEach items="${listCategory}" var="Categories">
<section>
  <div class="container my-5">
    <header class="mb-4">
      <h3>${Categories.name}</h3>
    </header>

    <div class="row">
        <c:forEach items="${listProducts}" var="Products">
                <c:if test="${Categories.id == Products.id_category && Products.status == 1}">
            <div class="col-lg-3 col-md-6 col-sm-6 d-flex">
          <div class="card w-100 my-2 shadow-2-strong">
            <img src="./assets/images/${Products.image}" class="card-img-top" style="aspect-ratio: 1 / 1" />
            <div class="card-body d-flex flex-column">
              <h5 class="card-title">${Products.name}</h5>
              <p class="card-text">$${Products.price}</p> 
              <div class="card-footer d-flex align-items-end pt-3 px-0 pb-0 mt-auto">            
                    <a href="./addProduct?id_Products=${Products.id}" class="btn btn-primary shadow-0 me-1">Add to cart</a>
                    <a href="#!" class="btn btn-light border px-2 pt-2 icon-hover"><i class="fas fa-heart fa-lg text-secondary px-1"></i></a>
              </div>
            </div>
          </div>
        </div>
    
                </c:if>
        </c:forEach>
    </div>
  </div>
</section>
</c:forEach>
  </c:if>
  <c:if test = "${id_category!=null}">
  <c:forEach items="${listCategory}" var="Categories">
     <c:if test="${Categories.id == id_category}">
    <section>
    <div class="container my-5">
      <header class="mb-4">
        <h3>${Categories.name}</h3>
      </header>

    <div class="row">
        <c:forEach items="${listProducts}" var="Products">
                <c:if test="${Categories.id == Products.id_category}">
          <div class="col-lg-3 col-md-6 col-sm-6 d-flex">
          <div class="card w-100 my-2 shadow-2-strong">
            <img src="./assets/images/${Products.image}" class="card-img-top" style="aspect-ratio: 1 / 1" />
            <div class="card-body d-flex flex-column">
              <h5 class="card-title">${Products.name}</h5>
              <p class="card-text">$${Products.price}</p> 
              <div class="card-footer d-flex align-items-end pt-3 px-0 pb-0 mt-auto">            
                    <a href="./addProduct?id_Products=${Products.id}" class="btn btn-primary shadow-0 me-1">Add to cart</a>
                    <a href="#!" class="btn btn-light border px-2 pt-2 icon-hover"><i class="fas fa-heart fa-lg text-secondary px-1"></i></a>
              </div>
            </div>
          </div>
        </div>
    
                </c:if>
        </c:forEach>
    </div>
  </div>
</section>
    </c:if>
   </c:forEach>
  </c:if>