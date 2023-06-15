package net.youssfi.accountdataservice.mapper;

import net.youssfi.accountdataservice.model.Customer;
import net.youssfi.customerdataservice.stub.CustomerServiceGrpc;
import net.youssfi.customerdataservice.stub.CustomerServiceOuterClass;
import net.youssfi.customerdataservice.web.CustomerById;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    private ModelMapper modelMapper=new ModelMapper();
    public Customer fromSoapCustomer(net.youssfi.customerdataservice.web.Customer soapCustomer){
        return modelMapper.map(soapCustomer,Customer.class);
    }
    public Customer fromGrpcCustomer(CustomerServiceOuterClass.Customer grpcCustomer){
        return modelMapper.map(grpcCustomer, Customer.class);
    }
}
