package com.edu.pe;

import com.edu.pe.models.Proveedor;
import com.edu.pe.repository.ProveedorRepository;
import com.edu.pe.service.impl.ProveedorServiceImpl;
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
public class ProveedorServiceImplTest {
    @Mock
    private ProveedorRepository repository;
    @InjectMocks
    private ProveedorServiceImpl service;

    @Test
    public void testListado() {
        Proveedor a = new Proveedor();
        a.setId_proveedor(1);
        a.setNombre("prueba");
        a.setRuc("prueba");
        a.setDireccion("prueba");
        a.setCelular("prueba");
        a.setUpdated_at(Calendar.getInstance());
        a.setCreated_at(Calendar.getInstance());

        List<Proveedor> list = new ArrayList<>();
        list.add(a);

        Assert.assertEquals(1,list.size());
        Assert.assertNotNull(repository.findAll());
        Assert.assertNotNull(service.Listado());
    }

    @Test
    public void testBuscarPorId() {
        Proveedor a = new Proveedor();
        a.setId_proveedor(1);
        a.setNombre("prueba");
        a.setRuc("prueba");
        a.setDireccion("prueba");
        a.setCelular("prueba");
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
        Proveedor a = new Proveedor();
        a.setId_proveedor(1);
        a.setNombre("prueba");
        a.setRuc("prueba");
        a.setDireccion("prueba");
        a.setCelular("prueba");
        a.setUpdated_at(Calendar.getInstance());
        a.setCreated_at(Calendar.getInstance());

        Assert.assertEquals("prueba",a.getNombre());
        service.Guardar(a);
        Mockito.verify(repository).save(a);
    }
}
