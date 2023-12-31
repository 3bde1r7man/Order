package aamm.order;

import aamm.order.model.Customer;

public interface Validator {
    public boolean validate(Customer customer);
}
