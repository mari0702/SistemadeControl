package com.edu.pe;

import com.edu.pe.models.Administrador;
import com.edu.pe.models.Usuario;
import com.edu.pe.repository.AdministradorRepository;
import com.edu.pe.service.impl.AdministradorServiceImpl;
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
public class AdministradorServiceImplTest {

    @Mock
    private AdministradorRepository repository;
    @InjectMocks
    private AdministradorServiceImpl service;

    @Test
    public void testListado() {
        Administrador a = new Administrador();
        a.setId_admin(1);
        a.setUsuario(new Usuario());
        a.setNombre("prueba");
        a.setApellido("prueba");
        a.setDni("prueba");
        a.setCelular("prueba");
        a.setDireccion("prueba");
        a.setFecha_nacimiento(Calendar.getInstance());
        a.setUpdated_at(Calendar.getInstance());
        a.setCreated_at(Calendar.getInstance());

        List<Administrador> list = new ArrayList<>();
        list.add(a);

        Assert.assertEquals(1,list.size());
        Assert.assertNotNull(repository.findAll());
        Assert.assertNotNull(service.Listado());
    }

    @Test
    public void testBuscarPorId() {
        Administrador a = new Administrador();
        a.setId_admin(1);
        a.setUsuario(new Usuario());
        a.setNombre("prueba");
        a.setApellido("prueba");
        a.setDni("prueba");
        a.setCelular("prueba");
        a.setDireccion("prueba");
        a.setFecha_nacimiento(Calendar.getInstance());
        a.setUpdated_at(Calendar.getInstance());
        a.setCreated_at(Calendar.getInstance());

        service.BuscarPorId(1);
        Mockito.verify(repository).findById(1);
    }

    @Test
    public void testEliminar() {
        Administrador a = new Administrador();
        a.setId_admin(1);
        service.Eliminar(1);
        Mockito.verify(repository).deleteById(1);
    }

    @Test
    public void testGuardar() {
        Administrador a = new Administrador();
        a.setId_admin(1);
        a.setUsuario(new Usuario());
        a.setNombre("prueba");
        a.setApellido("prueba");
        a.setDni("prueba");
        a.setCelular("prueba");
        a.setDireccion("prueba");
        a.setFecha_nacimiento(Calendar.getInstance());
        a.setUpdated_at(Calendar.getInstance());
        a.setCreated_at(Calendar.getInstance());

        Assert.assertEquals("prueba",a.getNombre());
        service.Guardar(a);
        Mockito.verify(repository).save(a);
    }
}
