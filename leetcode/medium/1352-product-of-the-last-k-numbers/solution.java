class ProductOfNumbers {
    List<Integer> prefix;
    public ProductOfNumbers() {
        prefix=new ArrayList<>();
    }
    
    public void add(int num) {
        if(num==0){
            prefix.clear();
            return;
        }
        int s=prefix.size();
        if(s==0)
            prefix.add(num);
        else
            prefix.add(num* prefix.get(prefix.size()-1));
    }
    
    public int getProduct(int k) {
        if(prefix.size()<k)return 0;
        // System.out.println("working  "+prefix.size()+" size");
        int last=prefix.get(prefix.size()-1);
        int relaxation=1;
        if(k!=prefix.size())
        relaxation=prefix.get(prefix.size()-k-1);
        return last/relaxation;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */