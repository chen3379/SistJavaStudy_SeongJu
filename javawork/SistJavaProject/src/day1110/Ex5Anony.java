package day1110;

interface Company{
	public void addItem();
	public void deleteItem();
	public void listItem();
}

public class Ex5Anony {
	
	Company co =new Company() {
		
		@Override
		public void listItem() {
			System.out.println("상품리스트");
		}
		
		@Override
		public void deleteItem() {
			System.out.println("상품삭제");
		}
		
		@Override
		public void addItem() {
			System.out.println("상품추가");
		}
	};

	public static void main(String[] args) {

		Ex5Anony ex=new Ex5Anony();
		ex.co.addItem();
		ex.co.deleteItem();
		ex.co.listItem();
	
	}
}
