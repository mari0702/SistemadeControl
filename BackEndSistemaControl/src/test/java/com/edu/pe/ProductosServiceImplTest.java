package com.edu.pe;

import com.edu.pe.models.Productos;
import com.edu.pe.models.Proveedor;
import com.edu.pe.repository.ProductosRepository;
import com.edu.pe.service.impl.ProductosServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ProductosServiceImplTest {


    @Mock
    private ProductosRepository repository;
    @InjectMocks
    private ProductosServiceImpl service;

    @Test
    public void testListado() {
        Productos a = new Productos();
        a.setId_prod(1);
        a.setProveedor(new Proveedor());
        a.setDescripcion("prueba");
        a.setCantidad(1);
        a.setPrecio(1);
        a.setUpdated_at(Calendar.getInstance());
        a.setCreated_at(Calendar.getInstance());

        List<Productos> list = new ArrayList<>();
        list.add(a);

        Assert.assertEquals(1,list.size());
        Assert.assertNotNull(repository.findAll());
        Assert.assertNotNull(service.Listado());
    }

    @Test
    public void testBuscarPorId() {
        Productos a = new Productos();
        a.setId_prod(1);
        a.setProveedor(new Proveedor());
        a.setDescripcion("prueba");
        a.setCantidad(1);
        a.setPrecio(1);
        a.setUpdated_at(Calendar.getInstance());
        a.setCreated_at(Calendar.getInstance());

        service.BuscarPorId(1);
        Mockito.verify(repository).findById(1);
    }

    @Test
    public void testEliminar() {
        service.Eliminar(1);
        Mockito.verify(repository).deleteById(1);
    }

    @Test
    public void testGuardar() {
        Productos a = new Productos();
        a.setId_prod(1);
        a.setProveedor(new Proveedor());
        a.setDescripcion("prueba");
        a.setCantidad(1);
        a.setPrecio(1);
        a.setUpdated_at(Calendar.getInstance());
        a.setCreated_at(Calendar.getInstance());

        Assert.assertEquals("prueba",a.getDescripcion());
        service.Guardar(a);
        Mockito.verify(repository).save(a);
    }
}
