public class Order_ extends Goods {
    private Integer order_id;
    private String time;

    public Order_() {super();}

    public Order_(Integer order_id, Integer id, String name, Integer price, String time) {
        super(id, name, price);
        this.order_id=order_id;
        this.time=time;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void changeId(Integer id) {
        setId(id);
    }

    public void changeName(String name) {
        setName(name);
    }

    public void changePrice(Integer price) {
        setPrice(price);
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", time='" + time + '\'' +
                '}';
    }
}
