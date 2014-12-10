package org.mockitousage.junitrule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.MethodRule;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.rules.MockitoJUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RuleTestWithFactoryMethodTest {

    @Rule
    public MethodRule mockitoJUnitRule = MockitoJUnit.rule();

    @Mock
    private Injected injected;

    @InjectMocks
    private InjectInto injectInto;

    @Test
    public void testInjectMocks() throws Exception {
        assertNotNull("Mock created", injected);
        assertNotNull("Object created", injectInto);
        assertEquals("A injected into B", injected, injectInto.getInjected());

    }

    public static class Injected {
    }

    public static class InjectInto {

        private Injected injected;

        public Injected getInjected() {
            return injected;
        }
    }
}