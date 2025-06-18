function addToCart(bookId){
    if(confirm("장바구니에 추가할?")){
        document.addForm.action = "/BookMarket/cart/book/"+bookId;
        document.addForm.submit();
    }

}

function removeFromCart(bookId,cartId){
    document.removeForm.action = "/BookMarket/cart/book/"+bookId;
    document.removeForm.submit();
    setTimeout('location.reload();', 10);
}
function deleteCart(cartId){
    if(confirm('Clear all Kat...Books?')) {
        document.deleteForm.submit();
        setTimeout('location.reload();', 10);
    }
}