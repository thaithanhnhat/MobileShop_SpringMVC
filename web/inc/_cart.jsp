<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<section class="h-100 h-custom" style="background-color: #d2c9ff;">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-12">
        <div class="card card-registration card-registration-2" style="border-radius: 15px;">
          <div class="card-body p-0">
            <div class="row g-0">
              <div class="col-lg-8">
                <div class="p-5">
                  <div class="d-flex justify-content-between align-items-center mb-5">
               
                    <h1 class="fw-bold mb-0 text-black">Shopping Cart</h1>
                  <c:if test="${user!=null}">
                    <h6 class="mb-0 text-muted">${listCarts.size()} items</h6>
                  </div>                
                    <hr class="my-4">
                    <c:if test="${listCarts.size()>0}">
                        <c:forEach items="${listCarts}" var="Cart">
                             <c:forEach items="${listProducts}" var="Products">
                                 <c:if test="${Cart.idProducts == Products.id }">
                              <div class="row mb-4 d-flex justify-content-between align-items-center">
                              <div class="col-md-2 col-lg-2 col-xl-2">
                                <img
                                  src="./assets/images/${Products.image}"
                                  class="img-fluid rounded-3" alt="Cotton T-shirt">
                              </div>
                              <div class="col-md-3 col-lg-3 col-xl-3">
                                <h6 class="text-black mb-0">${Products.name}</h6>
                              </div>
                              <div class="col-md-3 col-lg-3 col-xl-2 d-flex">
                                <button class="btn btn-link px-2"
                                  onclick="this.parentNode.querySelector('input[type=number]').stepDown()">
                                  <i class="fas fa-minus"></i>
                                </button>

                                <input id="form1" min="0" name="quantity" value="${Cart.quantity}" price="${Products.price}" type="number"
                                class="form-control form-control-sm" />

                                <button class="btn btn-link px-2"
                                  onclick="this.parentNode.querySelector('input[type=number]').stepUp()">
                                  <i class="fas fa-plus"></i>
                                </button>
                              </div>
                              <div class="col-md-3 col-lg-2 col-xl-2 offset-lg-1">
                                <h6 class="mb-0">$${Products.price}</h6>
                              </div>

                              <form action="" method="POST" class="col-md-1 col-lg-1 col-xl-1 text-end">
                                  <input type="hidden" name="delete" value="${Products.id}">
                                <button type="submit" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                              </form>
                              </div>
                              <hr class="my-4">   
                                 </c:if>
                               </c:forEach>
                        </c:forEach>
                    </c:if>
                    <c:if test="${listCarts.size()==0}">
                        <div class="alert alert-warning alert-dismissible fade show" role="alert">
                            <strong>Hi!</strong> Cart is empty <a href="home" class="fw-bold">shopping now</a>.                           
                        </div>
                        <hr class="my-4">
                    </c:if> 
                  <!-- done order -->
                  
             
                
                </div>
              </div>
              <div class="col-lg-4 bg-grey">
                <div class="p-5">
                  <h3 class="fw-bold mb-5 mt-2 pt-1">Summary</h3>
                  <hr class="my-4">

                  <div >
                      <img style="height: 80px;width: 120px" src="https://trustweb.vn/wp-content/uploads/2016/11/the-napas-la-gi-cong-thanh-toan-napas-la-gi-2411-7383.png" alt="alt"/>
                      <img style="height: 50px;width: 180px" src="https://rentacarnafplio.gr/wp-content/uploads/2019/04/visa_mastercard.png" alt="alt"/>
                  </div>
                    
                  <h5 class="text-uppercase mb-3">Phương thức thanh toán</h5>
                   
                   <div class="mb-4 pb-2">
                        <select style="width: 50%;height: 50px;" class="select" id="bankSelect">
                            <option  value="">Chọn phương thức</option>
                        </select>
                    </div>
                    <script>
                    const bankSelect = document.getElementById('bankSelect');
                    const apiUrl = 'https://api.vietqr.io/v2/banks';

                    fetch(apiUrl)
                      .then(response => response.json())
                      .then(data => {
                        data.data.forEach(bank => {
                          const option = document.createElement('option');
                          option.value = bank.code;

                          // Tạo phần tử span chứa tên ngân hàng và logo
                          const bankInfo = document.createElement('span');
                          bankInfo.textContent = bank.name;

                          // Tạo thẻ img để hiển thị logo ngân hàng
                          const logoImg = document.createElement('img');
                          logoImg.src = bank.logo;
                          logoImg.alt = bank.shortName;
                          logoImg.style.maxWidth = '50px'; // Điều chỉnh kích thước logo nếu cần

                          // Thêm logo vào phần tử span
                          bankInfo.appendChild(logoImg);

                          // Thêm phần tử span vào tùy chọn
                          option.appendChild(bankInfo);

                          bankSelect.appendChild(option);
                        });
                      })
                      .catch(error => {
                        console.error('Có lỗi xảy ra:', error);
                      });
                  </script>

                  <hr class="my-4">
                    
                  
                  <div class="d-flex justify-content-between mb-5">
                    <h5 class="text-uppercase">Total price</h5>
                    <h5 id="sumprice"></h5>
                  </div>
                   <script>
    // Lấy tất cả các thẻ input có id là "form1"
    const form1Inputs = document.querySelectorAll('input#form1');

    function calculateTotal() {
      let total = 0; // Tổng của tích value * price

      form1Inputs.forEach(input => {
        // Lấy giá trị từ thuộc tính value và price
        const value = parseFloat(input.value);
        const price = parseFloat(input.getAttribute('price'));

        // Kiểm tra nếu cả value và price là số hợp lệ thì tính tích và cộng vào tổng
        if (!isNaN(value) && !isNaN(price)) {
          const product = value * price;
          total += product;
        }
      });

      // Hiển thị tổng của tất cả các tích lên màn hình
      document.getElementById('sumprice').innerText = '$'+total.toFixed(2); // Hiển thị tổng với 2 chữ số sau dấu thập phân
    }

    // Gọi hàm tính tổng khi có bất kỳ thay đổi nào trên các thẻ input có id là "form1"
    form1Inputs.forEach(input => {
      input.addEventListener('input', calculateTotal);
    });

    // Tính tổng lúc ban đầu
    calculateTotal();
  </script>
                  <button type="button" class="btn btn-dark btn-block btn-lg"
                    data-mdb-ripple-color="dark">Thanh Toán</button>
             </c:if>
                  <c:if test="${user==null}">
                      <div class="alert alert-danger" role="alert">
                                Please log in!!!
                      </div>
                  </c:if>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
          