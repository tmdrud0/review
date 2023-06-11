function savePCodeAndReview(pcode) {
  // productName.json에 pcode 저장
  fetch('/api/savePCode', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({ pcode })
  })
  .then(response => response.json())
  .then(data => {
    console.log('pcode가 성공적으로 저장되었습니다.');
  })
  .catch(error => {
    console.error('pcode 저장 중 오류가 발생하였습니다:', error);
  });
}