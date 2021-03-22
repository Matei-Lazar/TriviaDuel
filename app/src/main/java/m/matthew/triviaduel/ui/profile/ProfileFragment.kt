package m.matthew.triviaduel.ui.profile

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth
import m.matthew.triviaduel.R
import m.matthew.triviaduel.databinding.FragmentProfileBinding
import m.matthew.triviaduel.login.LoginViewModel
import m.matthew.triviaduel.ui.home.HomeFragment

class ProfileFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentProfileBinding
    private lateinit var navController: NavController
    private val loginViewModel by viewModels<LoginViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var loopCheck = false

        navController = findNavController()

        loginViewModel.authenticationState.observe(viewLifecycleOwner, { authenticationState ->
            when (authenticationState) {
                LoginViewModel.AuthenticationState.AUTHENTICATED -> {
                    Log.i(TAG, "Authenticated")
                    loopCheck = false
                }

                LoginViewModel.AuthenticationState.UNAUTHENTICATED -> {
                    if (loopCheck) {
                        navController.popBackStack(R.id.homeFragment, false)
                    } else {
                        launchSignInFlow ()
                        loopCheck = true
                    }
                }

                else -> Log.e(
                        TAG, "New $authenticationState state that doesn't require any UI change"
                )
            }
        })
    }

    private fun launchSignInFlow() {

        val providers = arrayListOf(
                AuthUI.IdpConfig.EmailBuilder().build(),
                AuthUI.IdpConfig.GoogleBuilder().build()
                //
        )

        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .build(),
                HomeFragment.SIGN_IN_RESULT_CODE
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == HomeFragment.SIGN_IN_RESULT_CODE) {
            val response = IdpResponse.fromResultIntent(data)
            if (resultCode == Activity.RESULT_OK)
                // User successfully signed in
                Log.i(HomeFragment.TAG,
                        "Successfully signed in user ${FirebaseAuth.getInstance().currentUser?.displayName}!"
                )
            else {
                // Sign in failed. If response is null the user canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.
                Log.i(HomeFragment.TAG, "Sign in unsuccessful ${response?.error?.errorCode}")
                // If the user presses the back button, bring them back to the home screen
            }
        }
    }

    companion object {
        const val TAG = "ProfileFragment"
    }
}