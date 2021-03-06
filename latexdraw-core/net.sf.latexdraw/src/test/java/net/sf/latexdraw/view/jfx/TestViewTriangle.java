package net.sf.latexdraw.view.jfx;

import java.util.concurrent.TimeoutException;
import javafx.geometry.Bounds;
import javafx.scene.shape.Path;
import net.sf.latexdraw.data.ShapeSupplier;
import net.sf.latexdraw.models.interfaces.shape.ITriangle;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testfx.api.FxToolkit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TestViewTriangle extends TestViewBorderedShape<ViewTriangle, ITriangle, Path> {
	@BeforeClass
	public static void beforeClass() throws TimeoutException {
		FxToolkit.registerPrimaryStage();
	}

	@AfterClass
	public static void afterClass() throws TimeoutException {
		FxToolkit.cleanupStages();
	}

	@Override
	protected ITriangle createModel() {
		return ShapeSupplier.createTriangle();
	}

	@Test
	public void testDbleBorderNotEmpty() {
		assertFalse(view.dblBorder.getElements().isEmpty());
	}

	@Test
	public void testShadowNotEmpty() {
		assertFalse(view.shadow.getElements().isEmpty());
	}

	@Test
	@Override
	public void testOnTranslateX() {
		final Bounds before = view.getBorder().getBoundsInParent();
		model.translate(17d, 0d);
		view.getBorder().setTranslateX(-17d);
		assertEquals(before, view.getBorder().getBoundsInParent());
	}

	@Test
	@Override
	public void testOnTranslateY() {
		final Bounds before = view.getBorder().getBoundsInParent();
		model.translate(0d, -19d);
		view.getBorder().setTranslateY(19d);
		assertEquals(before, view.getBorder().getBoundsInParent());
	}

	@Test
	@Override
	public void testShadowPositionSameThanBorder() {
		assertEquals(view.getBorder().getElements(), view.getShadow().get().getElements());
	}
}
