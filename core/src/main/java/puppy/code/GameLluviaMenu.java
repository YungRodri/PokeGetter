package puppy.code;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

	public class GameLluviaMenu extends Game {

		private SpriteBatch batch;
		private BitmapFont font;
		private int higherScore;

		public void create() {
			batch = new SpriteBatch();
			font = new BitmapFont(); // use libGDX's default Arial font
			this.setScreen(new MainMenuScreen(this));
		}

        @Override
		public void render() {
			super.render(); // important!
		}

        @Override
        public void dispose() {
            if (getScreen() != null) {
                getScreen().dispose();
            }

            if (batch != null) {
                batch.dispose();
            }

            if (font != null) {
                font.dispose();
            }

            GestorRecursos.getInstance().liberarRecursos();
        }

		public SpriteBatch getBatch() {
			return batch;
		}

		public BitmapFont getFont() {
			return font;
		}

		public int getHigherScore() {
			return higherScore;
		}

		public void setHigherScore(int higherScore) {
			this.higherScore = higherScore;
		}


	}
