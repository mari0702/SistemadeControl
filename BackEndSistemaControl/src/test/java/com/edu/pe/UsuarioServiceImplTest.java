package com.edu.pe;

import com.edu.pe.models.Usuario;
import com.edu.pe.models.Usuario;
import com.edu.pe.repository.UsuarioRepository;
import com.edu.pe.service.impl.UsuarioServiceImpl;
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
public class UsuarioServiceImplTest {
    @Mock
    private UsuarioRepository repository;
    @InjectMocks
    private UsuarioServiceImpl service;

    @Test
    public void testListado() {
        Usuario a = new Usuario();
        a.setId_usuario(1);
        a.setUsername("prueba");
        a.setContrasenia("prueba");
        a.setUpdated_at(Calendar.getInstance());
        a.setCreated_at(Calendar.getInstance());

        List<Usuario> list = new ArrayList<>();
        list.add(a);

        Assert.assertEquals(1,list.size());
        Assert.assertNotNull(repository.findAll());
        Assert.assertNotNull(service.Listado());
    }

    @Test
    public void testBuscarPorId() {
        Usuario a = new Usuario();
        a.setId_usuario(1);
        a.setUsername("prueba");
        a.setContrasenia("prueba");
        a.setUpdated_at(Calendar.getInstance());
        a.setCreated_at(Calendar.getInstance());

        service.BuscarPorId(2);
        Mockito.verify(repository).findById(1);
    }

    @Test
    public void testBuscarUsuario() {
        Usuario a = new Usuario();
        a.setId_usuario(1);
        a.setUsername("prueba");
        a.setContrasenia("prueba");
        a.setUpdated_at(Calendar.getInstance());
        a.setCreated_at(Calendar.getInstance());

        service.BuscarUsuario(a.getUsername(), a.getContrasenia());
        Mockito.verify(repository).BuscarUsuario("prueba", "prueba");
    }

    @Test
    public void testEliminar() {
        service.Eliminar(1);
        Mockito.verify(repository).deleteById(1);
    }

    @Test
    public void testGuardar() {
        Usuario a = new Usuario();
        a.setId_usuario(1);
        a.setUsername("prueba");
        a.setContrasenia("prueba");
        a.setUpdated_at(Calendar.getInstance());
        a.setCreated_at(Calendar.getInstance());


        Assert.assertEquals("prueba",a.getUsername());
        service.Guardar(a);
        Mockito.verify(repository).save(a);
    }
}
